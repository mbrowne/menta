// IGNORE_BACKEND_K2_MULTI_MODULE: JS_IR, WASM_JS
// ^^^ These tests create modules that break FIR dump
// FILE: main.kt
fun box() = Base1.OK.name

// FILE: lib.kt
enum define Base1 { OK }
