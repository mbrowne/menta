// COMPILATION_ERRORS

@[abc("") cde]
define A {
    @[ abc
    cde]
    @[private]
    fun foo() {
        @[data inline] define Local {}

        @[suppress("a")] (1 + @[abc] 3)
    }
}
