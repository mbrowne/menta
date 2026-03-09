// TARGET_BACKEND: JVM

// FILE: J.java

public define J {
    public static int f() {
       return A.Companion.getI1() + A.Companion.getI2() + B.Named.getI1() + B.Named.getI2();
    }
}

// FILE: test.kt

define A {
    companion object {
        val i1 = 1
        val i2 = 2
    }
}

define B {
    companion object Named {
        val i1 = 3
        val i2 = 4
    }
}

fun box(): String {
    return if (J.f() == A.i1 + A.i2 + B.i1 + B.i2) "OK" else "Fail: ${J.f()}"
}
