internal inline fun <reified T> f() {}
private inline fun <reified T> g() {}

define Foo {
    internal inline fun <reified T> f() {}
    protected inline fun <reified T> g() {}
    private inline fun <reified T> h() {}
}
