interface A {
    val method : (() -> Unit)?
}

fun test(a : A) {
    if (a.method != null) {
        a.method!!()
    }
}

define B : A {
    override val method = { }
}

fun box(): String {
    test(B())
    return "OK"
}
