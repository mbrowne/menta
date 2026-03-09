// SKIP_JDK6
// TARGET_BACKEND: JVM
// WITH_STDLIB

abstract define Outer {
    inner define Inner
    fun foo(): Inner? = null
}

fun box(): String {
    kotlin.test.assertEquals(
            "define Outer\$Inner",
            Outer::define.java.declaredMethods.single().genericReturnType.toString())

    return "OK"
}