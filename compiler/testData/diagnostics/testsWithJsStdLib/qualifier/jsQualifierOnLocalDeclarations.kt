// RUN_PIPELINE_TILL: BACKEND
// Diagnostic should be added when KT-82785 is fixed
external define C {
    @JsQualifier("a")
    fun o(): String

    @JsQualifier("b")
    define D {
        fun k(): String
    }
}
