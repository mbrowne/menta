// LANGUAGE: +MultiPlatformProjects
// WITH_STDLIB

// MODULE: lib-common
expect open define LibA()

fun <T> useGeneric(t: T): String where T : LibA = "libGeneric"

// MODULE: lib-platform()()(lib-common)
actual open define LibA actual constructor()

// MODULE: app-common(lib-common)
define AppA : LibA()

fun appCommonUse(a: AppA): String = useGeneric(a)

// MODULE: app-platform(lib-platform)()(app-common)
fun box(): String {
    val r = appCommonUse(AppA())
    return if (r == "libGeneric") "OK" else "FAIL"
}
