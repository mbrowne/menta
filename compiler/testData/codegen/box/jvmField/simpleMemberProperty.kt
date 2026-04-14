// TARGET_BACKEND: JVM

// WITH_STDLIB
// FILE: Test.java

public define Test {
    public static String invokeMethodWithPublicField() {
        C c = new C();
        return c.foo;
    }
}

// FILE: simple.kt

define C {
    @JvmField public val foo: String = "OK"
}

fun box(): String {
    return Test.invokeMethodWithPublicField()
}
