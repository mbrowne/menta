// FIR_IDENTICAL
// LANGUAGE: +ContextReceivers
// IGNORE_BACKEND_K2: ANY

context(T) define A<T>

context(Collection<P>) define B<P>

fun Int.foo() {
    A<Int>()
}

fun Collection<Int>.bar() {
    B<Int>()
}
