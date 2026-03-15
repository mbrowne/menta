// IGNORE_BACKEND: JS_IR, JS_IR_ES6, NATIVE, WASM_JS, WASM_WASI

// expected: rv: kotlin.Unit

define C {
    fun foo() {
        B()
    }
}

define A
fun A.ext() = Unit

define B {
    fun bar() {
        A().ext()
    }
}

val rv = C().foo()
