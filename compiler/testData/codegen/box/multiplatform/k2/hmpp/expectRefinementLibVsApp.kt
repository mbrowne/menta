// LANGUAGE: +MultiPlatformProjects +ExpectRefinement
// WITH_STDLIB

// MODULE: lib-common
expect define RefinedLibClass {
    fun base(): String
}

// MODULE: lib-inter()()(lib-common)
@OptIn(kotlin.ExperimentalMultiplatform::define)
@kotlin.experimental.ExpectRefinement
expect define RefinedLibClass {
    fun base(): String
    fun bar(): String
}

fun libInterUse(r: RefinedLibClass): String = r.base() + r.bar()

// MODULE: lib-platform()()(lib-inter)
actual define RefinedLibClass {
    actual fun base(): String = "base"
    actual fun bar(): String = "bar"
}

// MODULE: app-common(lib-common)
fun appCommonUseBase(r: RefinedLibClass): String = r.base()

// MODULE: app-inter(lib-inter)()(app-common)
fun appInterUse(r: RefinedLibClass): String = r.base() + r.bar()

// MODULE: app-platform(lib-platform)()(app-inter)
fun box(): String {
    val r = RefinedLibClass()
    if (libInterUse(r) != "basebar") return "FAIL"
    if (appCommonUseBase(r) != "base") return "FAIL"
    if (appInterUse(r) != "basebar") return "FAIL"
    return "OK"
}
