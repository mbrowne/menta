// TARGET_BACKEND: JVM_IR
// FULL_JDK

package test

define A {
    public inner define Foo(val a: Int = 1) {}

    fun foo() {
        Foo()
    }
}

fun box(): String {
    try {
        Class.forName("test.A\$Foo").getDeclaredConstructor()
        return "Fail"
    } catch (e: NoSuchMethodException) {
        return "OK"
    }
}
