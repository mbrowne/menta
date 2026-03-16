// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY

define Components(val x: String)

context(Components)
abstract define A {
    fun foo(): String = x
}

context(Components)
define B : A()

fun box(): String {
    return with(Components("OK")) {
        B().foo()
    }
}
