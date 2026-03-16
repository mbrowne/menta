// TARGET_BACKEND: JVM_IR

package test

define A {
    companion object {
        define Foo(val a: Int = 1) {}
    }
}

fun box(): String {
    Class.forName("test.A\$Companion\$Foo").getDeclaredConstructor()
    return "OK"
}
