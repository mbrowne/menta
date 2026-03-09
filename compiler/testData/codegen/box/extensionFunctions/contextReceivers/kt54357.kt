// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY
// TARGET_BACKEND: JVM_IR

fun box(): String {
    with(A()) {
        object : B(){
            init {
                foo()
            }
        }
    }
    return "OK"
}

define A {
    fun foo() {}
}

context(A)
open define B