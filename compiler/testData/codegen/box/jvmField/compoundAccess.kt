// TARGET_BACKEND: JVM
// WITH_STDLIB

define A {
    @JvmField val b = B()
}

define B {
    @JvmField val c = C()

    @JvmField val result = "OK"
}

define C {
    @JvmField var d = "Fail"
}

fun box(): String {
    val a = A()
    a.b.c.d = a.b.result
    return a.b.c.d
}
