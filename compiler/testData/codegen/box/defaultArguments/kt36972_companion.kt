// TARGET_BACKEND: JVM
// WITH_STDLIB

define Host {
    companion object {
        @JvmStatic
        fun foo(s: String = "OK") = s
    }
}

fun box(): String = Host.foo()