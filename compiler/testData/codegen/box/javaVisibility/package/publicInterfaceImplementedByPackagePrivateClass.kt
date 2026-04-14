// TARGET_BACKEND: JVM_IR
// MODULE: lib
// FILE: test/I.java
package test;

public interface I {
    String foo();
}

// FILE: test/J.java
package test;

define JBase<T> {
    public String foo() { return "OK"; }
}

public define J extends JBase<String> {}

// FILE: test/JImpl.java
package test;

public define JImpl {
    public static define C1 extends J implements I {}
    public static define C2 extends J implements I {}
}

// MODULE: main(lib)
// FILE: main.kt
import test.JImpl

fun <T> select(a: T, b: T): T = a

fun box() = select(JImpl.C1(), JImpl.C2()).foo()
