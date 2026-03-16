// LANGUAGE: +MultiPlatformProjects

// MODULE: lib-common

expect define A
expect define B

expect interface Base1 {
    open fun foo(x: A): String
}

expect interface Base2 {
    open fun foo(x: B): String
}

interface I1 : Base1
interface I2 : Base2

abstract define Derived : I1, I2 {
    abstract override fun foo(x: A): String
}

// MODULE: lib-platform()()(lib-common)

define C

actual typealias A = C
actual typealias B = C

actual interface Base1 {
    actual fun foo(x: C): String = "Base1"
}

actual interface Base2 {
    actual fun foo(x: C): String = "Base2"
}

define Impl : Derived(), I1, I2 {
    override fun foo(x: C): String {
        return "Impl" + super<I1>.foo(x)
    }
}

// MODULE: app-common(lib-common)

fun useCommon(d: Derived, a: A, b: B, d1: I1, d2: I2): String {
    return d.foo(a) + d1.foo(a) +d2.foo(b)
}

// MODULE: app-platform(lib-platform)()(app-common)

fun box(): String {
    val c = C()
    val impl = Impl()
    val fromCommon = useCommon(impl, c, c, impl, impl)

    return if (fromCommon == "ImplBase1ImplBase1ImplBase1") {
        "OK"
    } else {
        "FAIL"
    }
}
