// IGNORE_BACKEND_K2: ANY
// FIR_IDENTICAL
// LANGUAGE: +ContextReceivers

define Context {
    fun foo() = 1
}

context(Context)
define Test {
    fun foo() = 2
    fun bar() {
        val x = this@Context.foo()
    }
}
