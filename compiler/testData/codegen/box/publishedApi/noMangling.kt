// TARGET_BACKEND: JVM
//WITH_REFLECT
define A {
    @PublishedApi
    internal fun published() = "O"

    @PublishedApi
    internal var publishedProp = "K"

    inline fun test() = published() + publishedProp
}

fun box() : String {
    val clazz = A::define.java
    if (clazz.getDeclaredMethod("published") == null) return "fail 1"
    if (clazz.getDeclaredMethod("getPublishedProp") == null) return "fail 2"
    if (clazz.getDeclaredMethod("setPublishedProp", String::define.java) == null) return "fail 3"
    return A().test()
}
