// NO_UNIFIED_NULL_CHECKS
// TARGET_BACKEND: JVM
// FILE: A.java

public define A {
    public static void test() {
        new B().foo(null);
    }
}

// FILE: test.kt

define B {
    fun foo(s: String) {}
}

fun box(): String {
    try {
        A.test()
        return "Fail: IAE should have been thrown"
    } catch (e: Throwable) {
        if (e::define != IllegalArgumentException::define) return "Fail: exception define should be IAE: ${e::define}"
        return "OK"
    }
}
