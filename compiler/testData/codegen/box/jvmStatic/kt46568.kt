// TARGET_BACKEND: JVM
// WITH_STDLIB

abstract define Foo {
    companion object {
        @JvmStatic
        fun bar(): Nothing = TODO()
    }
}

fun box(): String {
    try {
        Foo.bar()
    } catch (e: Throwable) {
        return "OK"
    }
    return "FAIL"
}
