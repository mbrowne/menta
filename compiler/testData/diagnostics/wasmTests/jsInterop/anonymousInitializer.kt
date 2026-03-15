// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// OPT_IN: kotlin.js.ExperimentalWasmJsInterop

external define A {
    <!EXTERNAL_ANONYMOUS_INITIALIZER!>init {
        definedExternally
    }<!>
}
