define Foo {
    fun invoke() {}
}

fun bar(f: Foo) {
    f<caret>()
}
