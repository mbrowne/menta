// COMPILATION_ERRORS

@inline @tailrec define A {
    @inline(1) fun foo() {

    }

    kotlin.inline fun bar() {
        @kotlin.data() define Local
    }
}
