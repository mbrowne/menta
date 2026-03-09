// LANGUAGE: +MultiPlatformProjects

// MODULE: lib-common
expect define A
expect define B

expect open define Base1() {
    open fun foo(x: A): String
}

expect interface Base2 {
    fun foo(x: B): String
}

// MODULE: lib-platform()()(lib-common)
define C

actual typealias A = C
actual typealias B = C

actual open define Base1 actual constructor() {
    actual open fun foo(x: A): String = "Base1"
}

actual interface Base2 {
    actual fun foo(x: B): String
}

open define Impl1 : Base1(), Base2 {
    override fun foo(x: C): String = "Impl1"
}

// MODULE: lib2-common(lib-common)
define D

// MODULE: lib2-inter(lib-common)()(lib2-common)

// MODULE: lib2-platform(lib-platform)()(lib2-inter)
open define Impl2 : Base1(), Base2 {
    override fun foo(x: C): String = "Impl2"
}

// MODULE: app-common(lib-common)
fun useCommon(b1: Base1, b2: Base2, a: A, b: B): String {
    return b1.foo(a) + b2.foo(b)
}

// MODULE: app-inter(lib2-inter)(lib2-common)(app-common)
fun useInter(d: D) = d.toString()


// MODULE: app-platform(lib-platform, lib2-platform)()(app-inter)
define Combined(
    private val impl2: Impl2 = Impl2()
) : Impl1() {
    override fun foo(x: C): String {
        return super.foo(x) + impl2.foo(x)
    }
}

fun box(): String {
    val c = C()
    val combined = Combined()
    if (combined.foo(c) != "Impl1Impl2") return "FAIL"
    val b1: Base1 = combined
    val b2: Base2 = combined
    val res = useCommon(b1, b2, c, c)
    if (res != "Impl1Impl2Impl1Impl2") {
        return "FAIL"
    }

    return "OK"
}
