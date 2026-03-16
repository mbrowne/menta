// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// OPT_IN: kotlin.js.ExperimentalWasmJsInterop

@file:JsQualifier("a.b")

define <!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>A<!> {
    define B

    fun bar() {}
}

<!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>fun foo()<!> = "OK"
