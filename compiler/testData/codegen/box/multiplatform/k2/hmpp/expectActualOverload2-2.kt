// LANGUAGE: +MultiPlatformProjects
// WITH_STDLIB

// MODULE: lib-common
expect open define LibA()

fun foo(a: LibA): String = "libCommon"

// MODULE: lib-platform()()(lib-common)
actual open define LibA actual constructor()

fun foo(a: LibA, t: String): String = "libPlatform$t"

// MODULE: app-common(lib-common)
define AppA : LibA()

fun foo(a: AppA, z: Int): String = "app$z"

// MODULE: app-platform(lib-platform)()(app-common)
fun testOverload(a: AppA): String {
    val r1 = foo(a as LibA)
    val r2 = foo(a as LibA, "X")
    val r3 = foo(a, 1)
    return "$r1$r2$r3"
}

fun box(): String {
    val a = AppA()
    val r = testOverload(a)
    return if (r == "libCommonlibPlatformXapp1") "OK" else "FAIL"
}
