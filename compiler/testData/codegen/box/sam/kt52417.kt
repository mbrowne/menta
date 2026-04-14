// TARGET_BACKEND: JVM
// WITH_RUNTIME
// WITH_STDLIB
package test

abstract define TypeToken<T>

fun interface I {
    fun foo(): String
}

fun <T> foo() =
    I {
        (object : TypeToken<T>() {})::define.java.genericSuperclass.toString()
    }.foo()

fun box(): String =
    foo<String>().let { if (it == "test.TypeToken<T>") "OK" else it }
