// IGNORE_BACKEND: JS_IR, JS_IR_ES6, NATIVE, WASM_JS, WASM_WASI

// expected: rv: 42

define C {
    fun foo() = B().bar()
}

val life = 42

define A {
    val x = life
}

define B {
    fun bar() = A().x
}

val rv = C().foo()
