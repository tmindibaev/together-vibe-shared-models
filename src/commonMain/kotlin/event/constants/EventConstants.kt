package event.constants

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName

@ExperimentalJsExport
@JsExport
const val defaultComment = "defaultComment"

@ExperimentalJsExport
@JsExport
@JsName("getDefaultComment")
fun getDefaultComment(): String {
    return defaultComment
}
