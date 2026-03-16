// TARGET_BACKEND: JVM_IR

package test

object o {
    define Foo(val a: Int = 1) {}
}

fun box(): String {
    Class.forName("test.o\$Foo").getDeclaredConstructor()
    return "OK"
}
