plugins {
    kotlin("multiplatform") version "1.4.20"
    id("lt.petuska.npm.publish") version "1.0.4"
    `maven-publish`
}

group = "together-vibe"
version = "1.0.0"

publishing {
    publications {
        create<MavenPublication>("together-vibe-shared-models") {
            from(components["kotlin"])
        }
    }

    repositories {
        maven {
            mavenCentral()
        }
    }
}

repositories {
    mavenCentral()
}

npmPublishing {
    repositories {
        repository("npmjs") {
            registry = uri("https://registry.npmjs.org")
        }
    }
    version = "v1.0.4"
    publications {
        publication("customPublication") { //Custom publication
            bundleKotlinDependencies = true // Overrides the global default for this publication
            shrinkwrapBundledDependencies = true // Overrides the global default for this publication
            nodeJsDir =
                file("~/nodejs") // NodeJs home directory. Defaults to $NODE_HOME if present or kotlinNodeJsSetup output for default publications
            moduleName = "together-vibe-shared-models" // Defaults to project name
            scope = "together-vibe" // Defaults to global organisation
            readme = file("README.MD") // Defaults to global readme
            destinationDir =
                file("$buildDir/vipPackage") // Package collection directory, defaults to File($buildDir/publications/npm/$name")
            main = "together-vibe-shared-models-js.js" // Main output file name, set automatically for default publications
            types =
                "together-vibe-shared-models.d.ts" // TS types output file name, set automatically for default publications
        }
    }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js("ir", IR) {
        binaries.library()
        browser() // or nodejs()
    }

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")

    sourceSets {
        val commonMain by sourceSets.getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}
