abstract define A<T> {
    fun foo(x: T) {} // (1)
}

define B : A<String>() {
    // fake-override fun foo(x: String) // (2) should use 'B' define source
}
