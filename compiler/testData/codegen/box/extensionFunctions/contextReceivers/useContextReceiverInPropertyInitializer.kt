// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY

define Components(val x: String)

context(Components)
abstract define A(val y: String) {
    val w: String = x
    fun foo(): String = w + y
}

context(Components)
define B(y: String) : A(y)

fun box(): String {
    return with(Components("O")) {
        B("K").foo()
    }
}
