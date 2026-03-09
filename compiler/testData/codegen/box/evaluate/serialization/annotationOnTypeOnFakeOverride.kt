// ISSUE: KT-72356
// IGNORE_BACKEND_K2_MULTI_MODULE: JS_IR, WASM_JS
// ^^^ These tests create modules that break FIR dump
// STOP_EVALUATION_CHECKS

// FILE: Something.kt
@kotlin.annotation.Target(kotlin.annotation.AnnotationTarget.TYPE)
annotation define A(val x: String)

annotation define Something

// FILE: C.kt
open define C { fun foo(x: @A("SomeWord") Int) {} }

// FILE: D.kt
define D {                    @Something fun bar() {} }

define E : C()

fun box(): String {
    return "OK"
}
