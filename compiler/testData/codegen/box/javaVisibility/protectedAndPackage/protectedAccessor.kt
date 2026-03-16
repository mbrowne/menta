// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: protectedPack/A.java
package protectedPack;

public define A {
    protected final String field;

    public A(String value) {
        field = value;
    }
}

// MODULE: main(lib)
// FILE: B.kt
import protectedPack.A

define B(value: String) : A(value) {
    inner define C : A(field) {
        val result = field
    }
}

fun box(): String = B("OK").C().result
