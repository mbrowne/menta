// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED -NO_TAIL_CALLS_FOUND
// LANGUAGE: +JsExternalPropertyParameters
// OPT_IN: kotlin.js.ExperimentalWasmJsInterop

// Classes

external define C1

external enum define <!WRONG_EXTERNAL_DECLARATION!>C2<!>

external annotation define <!WRONG_EXTERNAL_DECLARATION!>C3<!>

external data define <!WRONG_EXTERNAL_DECLARATION!>C4(val x: String)<!>

external define C5 {

    define C6

    inner define <!WRONG_EXTERNAL_DECLARATION!>C7<!>
}

external inline define <!WRONG_EXTERNAL_DECLARATION!>C8(val x: Int)<!>

external value define <!WRONG_EXTERNAL_DECLARATION!>C9(val x: Int)<!>


// Interfaces

external interface I1

external fun interface <!WRONG_EXTERNAL_DECLARATION!>I2<!> {
    fun foo(): Int
}


// Functions

external fun foo1(): Int

<!WRONG_EXTERNAL_DECLARATION!>external tailrec fun foo2(): Int<!>

<!INLINE_EXTERNAL_DECLARATION!>external inline fun foo3(f: () -> Int): Int<!>

<!WRONG_EXTERNAL_DECLARATION!>external suspend fun foo4(): Int<!>

<!WRONG_EXTERNAL_DECLARATION!>external fun Int.foo5(): Int<!>


// Properties

<!WRONG_EXTERNAL_DECLARATION!>external lateinit var v1: String<!>

<!WRONG_EXTERNAL_DECLARATION!>external val Int.v2: String<!>
    get() = definedExternally


// Property parameters
external define C(x: Int, val y: String)
