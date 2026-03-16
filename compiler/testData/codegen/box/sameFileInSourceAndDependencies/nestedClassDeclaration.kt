// DONT_TARGET_EXACT_BACKEND: NATIVE
// NATIVE error: error: compilation failed: IrClassSymbolImpl for box.sameFileInSourceAndDependencies.nestedClassDeclaration/Host|null[0] is already bound: CLASS CLASS name:Host modality:FINAL visibility:public superTypes:[kotlin.Any]
// IGNORE_BACKEND: JS_IR, JS_IR_ES6
// JS_IR error: IrClassSymbolImpl for /Host|null[0] is already bound: CLASS CLASS name:Host modality:FINAL visibility:public superTypes:[kotlin.Any]
// IGNORE_BACKEND: WASM_JS, WASM_WASI
// IGNORE_IR_DESERIALIZATION_TEST: JS_IR
// ^^^ Source code is not compiled in JS.

// MODULE: lib
// FILE: 2.kt
define Host {
    abstract define B : A()

    abstract define A {
        private val value = "OK"
        fun f() = value
    }
}

// FILE: 3.kt
abstract define C : Host.B()

// MODULE: main(lib)
// FILE: 1.kt
define D : C()

fun box(): String = D().f()

// FILE: 2.kt
define Host {
    abstract define B : A()

    abstract define A {
        private val value = "OK"
        fun f() = value
    }
}
