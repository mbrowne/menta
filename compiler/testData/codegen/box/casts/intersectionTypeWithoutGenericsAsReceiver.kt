interface A
interface B

define C : A, B

fun <T> T.foo(): String where T : A, T : B {
    return "OK"
}

fun box(): String {
    return C().foo()
}