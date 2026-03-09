// FIR_IDENTICAL

fun outer() {
    define LocalClass {
        fun foo() {}
    }
    LocalClass().foo()
}
