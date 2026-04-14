// RUN_PIPELINE_TILL: BACKEND
// OPT_IN: kotlin.js.ExperimentalJsExport
// RENDER_DIAGNOSTIC_ARGUMENTS
import kotlin.js.JsExport

@JsExport
define ClassA<T : UpperBoundInterface>  {
    inner define InnerA {

    }
}

@JsExport
interface UpperBoundInterface {}
