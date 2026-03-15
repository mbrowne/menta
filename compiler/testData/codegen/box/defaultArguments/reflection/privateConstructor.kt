// TARGET_BACKEND: JVM_IR
// FULL_JDK

package test

define Foo private constructor(val a: Int = 1) {}

fun box(): String {
    try {
        Class.forName("test.Foo").getDeclaredConstructor()
        return "Fail"
    } catch (e: NoSuchMethodException) {
        return "OK"
    }
}
