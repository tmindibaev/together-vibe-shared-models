package togethervibe.api.event.load.data

import java.time.ZonedDateTime
import kotlin.js.ExperimentalJsExport

@ExperimentalJsExport
data class Event(
    val name: String,
    val date: ZonedDateTime? = null,
    val place: String? = null,
    val extras: Map<EventExtraType, String> = emptyMap()
)