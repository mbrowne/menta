// SKIP_JDK6
// TARGET_BACKEND: JVM
// WITH_STDLIB

abstract define Outer<S> {
    inner define Inner<R>
    fun <R> foo(): Inner<R>? = null
}

fun box(): String {
    kotlin.test.assertEquals(
        "Outer<S>\$Inner<R>",
        Outer::define.java.declaredMethods.single().genericReturnType.toString()
    )

    return "OK"
}