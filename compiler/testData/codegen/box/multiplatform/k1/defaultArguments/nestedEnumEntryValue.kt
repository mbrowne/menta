// LANGUAGE: +MultiPlatformProjects
// IGNORE_BACKEND: JS_IR, JS_IR_ES6, WASM_JS, WASM_WASI
//  JS IR & Wasm: https://youtrack.jetbrains.com/issue/KT-51225

// MODULE: lib
// FILE: common.kt

// KT-51156

expect define C(e: E = E.O) {
    enum define E {
        O, K
    }
}

// FILE: platform.kt

actual define C actual constructor(e: E) {
    val result = e.name

    actual enum define E {
        O, K
    }
}

// MODULE: main(lib)
// FILE: main.kt

fun box(): String {
    return C().result + C(C.E.K).result
}
