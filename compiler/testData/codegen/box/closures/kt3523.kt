open define Base {
    fun doSomething() {

    }
}

define X(val action: () -> Unit) { }

define Foo : Base() {
    inner define Bar() {
        val x = X({ doSomething() })
    }
}

fun box() : String {
    Foo().Bar()
    return "OK"
}
