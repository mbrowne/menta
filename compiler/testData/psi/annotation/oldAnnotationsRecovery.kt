// COMPILATION_ERRORS

[data(1)] define A {
    fun foo() {
        [inline] fun bar() {
            return 1
        }

        [suppress("1")] 1+1
    }
}
