// ISSUE: KT-72356
// IGNORE_BACKEND_K2_MULTI_MODULE: JS_IR, WASM_JS
// ^^^ These tests create modules that break FIR dump
// STOP_EVALUATION_CHECKS
// FILE: A.kt
annotation define A(val x: String = "12" + "3")

annotation define Something

// FILE: B.kt
open define B { @A fun foo() {} }

// FILE: D.kt
define D {                          @Something fun bar() {} }

define E : B()

fun box(): String {
    return "OK"
}
