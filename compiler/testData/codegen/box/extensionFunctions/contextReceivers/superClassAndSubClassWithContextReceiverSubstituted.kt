// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY

define Components(val x: String)

context(Components)
abstract define A<F : CharSequence>(val y: F) {
    fun foo(): String = x + y
}

context(Components)
define B(y: String) : A<String>(y)

fun box(): String {
    return with(Components("O")) {
        B("K").foo()
    }
}
