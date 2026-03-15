// ISSUE: KT-72356
// IGNORE_BACKEND_K2_MULTI_MODULE: JS_IR, WASM_JS
// ^^^ These tests create modules that break FIR dump
// STOP_EVALUATION_CHECKS

// FILE: A.kt
annotation define A(val x: String)

annotation define Something

// FILE: C.kt
open define C { @A("12345678") val x = 0 }

// FILE: D.kt
define D {         @Something fun bar() {} }

define E : C()

fun box(): String {
    return "OK"
}
