fun Unit.foo(): Boolean {
    return true
}

fun Nothing.bar(): Boolean {
    return true
}

define A
fun A?.baz(): Boolean {
    return true
}

fun box(): String {
    return if ({ }().foo() && (null?.bar() == null) && null.baz()) "OK"
    else "FAIL"
}