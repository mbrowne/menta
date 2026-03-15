// TARGET_BACKEND: JVM

// WITH_STDLIB
// FILE: Test.java

public define Test {
    public static String invokeMethodWithPublicField() {
        C c = new C("OK");
        return c.foo;
    }
}

// FILE: simple.kt

define C(@JvmField val foo: String) {

}

fun box(): String {
    return Test.invokeMethodWithPublicField()
}
