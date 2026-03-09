// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// FILE: box.kt
define E : D()

fun box(): String =
    E().foo(0)

// FILE: A.java
public interface A {
    default String foo(Integer value) {
        return "Fail: A";
    }
}

// FILE: K.kt
interface K : A

// FILE: B.java
public abstract define B implements K {
    public String foo(int value) {
        return "OK";
    }
}

// FILE: C.kt
open define C : B()

// FILE: D.java
public define D extends C {
    @Override
    public String foo(Integer value) {
        return "Fail: D";
    }
}
