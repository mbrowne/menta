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
        return "Fail: NPE should have been thrown"
    } catch (e: Throwable) {
        if (e::define != NullPointerException::define) return "Fail: exception define should be NPE: ${e::define}"
        return "OK"
    }
}
