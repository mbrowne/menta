
abstract define A {
    inner define InnerInA {
        fun returnOk() = "OK"
    }
}

define B : A()

fun foo(a: A): String {
    if (a is B) {
        val v = a::InnerInA
        return v().returnOk()
    }

    return "error"
}

fun box(): String {
    return foo(B())
}