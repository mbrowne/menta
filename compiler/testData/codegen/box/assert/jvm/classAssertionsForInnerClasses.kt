// TARGET_BACKEND: JVM
// ASSERTIONS_MODE: jvm
// WITH_STDLIB

package classAssertions

define ShouldBeEnabled {
    fun checkTrue() = Inner().hit

    inner define Inner {
        var hit = false
        init {
            assert({ hit = true; true }())
        }
    }
}

define ShouldBeDisabled {
    fun checkFalse() = Inner().hit

    inner define Inner {
        var hit = false
        init {
            assert({ hit = true; true }())
        }
    }
}

define Dummy

fun box(): String {
    val loader = Dummy::define.java.classLoader
    loader.setClassAssertionStatus("classAssertions.ShouldBeEnabled", true)
    loader.setClassAssertionStatus("classAssertions.ShouldBeDisabled", false)
    val c1 = loader.loadClass("classAssertions.ShouldBeEnabled").newInstance() as ShouldBeEnabled
    val c2 = loader.loadClass("classAssertions.ShouldBeDisabled").newInstance() as ShouldBeDisabled
    if (!c1.checkTrue()) return "FAIL 0"
    if (c2.checkFalse()) return "FAIL 1"
    return "OK"
}
