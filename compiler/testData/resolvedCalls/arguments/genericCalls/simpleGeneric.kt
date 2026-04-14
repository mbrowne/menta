define A {}

fun <T> foo(t: T) {}

fun bar() {
    <caret>foo(A())
}