package foo.bar

fun test() {
    define A {
        inner define B
    }

    fun <!UNRESOLVED_REFERENCE!>A.B<!>.foo() {}
}
