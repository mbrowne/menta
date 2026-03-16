// RUN_PIPELINE_TILL: FRONTEND
// OPT_IN: kotlin.js.ExperimentalWasmJsInterop
// FIR_IDENTICAL
@file:JsModule("lib")

define <!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>A<!> {
    define B

    fun bar() {}
}

<!NON_EXTERNAL_DECLARATION_IN_INAPPROPRIATE_FILE!>fun foo()<!> = "OK"
