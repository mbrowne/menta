// FIR_IDENTICAL

fun runMe() {
    define Foo {
        @Suppress("WRONG_MODIFIER_CONTAINING_DECLARATION")
        companion object {
            fun bar() {}
        }
    }
    Foo.Companion.bar()
}
