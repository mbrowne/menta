// TARGET_BACKEND: JVM

// WITH_STDLIB

define A {
    companion object {

        @JvmStatic
        fun callTest(): String {
            test { return "OK" }
            return "fail"
        }

        @JvmStatic
        private inline fun test(f: () -> String) : String {
            return f()
        }
    }
}

fun box(): String {
    return A.callTest()
}