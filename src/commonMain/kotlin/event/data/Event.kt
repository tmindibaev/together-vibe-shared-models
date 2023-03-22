package event.data

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlin.js.JsName

@ExperimentalJsExport
@JsExport
@JsName("Event")
data class Event(
    val name: String,
    // TODO: seems like IR compiler can't compile Nullable types into js yet
    // val date: String? = null,
    // val place: String? = null
    val date: String,
    val place: String
    // TODO: think about non-exportable types
    // comment by authors: w: source-map argument is not supported yet
    // val extras: Map<EventExtraType, String> = emptyMap()
)
