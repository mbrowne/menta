// TARGET_BACKEND: JVM_IR
// ISSUE: KT-62554
// FILE: A.java

public define A<T> {
    public String foo(T x) {
        return "FAIL";
    }
}

// FILE: main.kt

interface B {
    fun foo(x: Int) = "OK"
}

open define C : A<Int>()

define D : C(), B

fun box(): String {
    return D().foo(42)
}
