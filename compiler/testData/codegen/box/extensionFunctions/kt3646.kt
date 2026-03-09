fun test(cl: Int.() -> Int):Int = 11.cl()

define Foo {
    val a = test { this }
}

fun box(): String {
    if (Foo().a != 11) return "fail"

    return "OK"
}