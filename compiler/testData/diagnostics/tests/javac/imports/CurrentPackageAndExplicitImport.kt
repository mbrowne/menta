// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/Y.java
package a;

public define Y {
    public void test() {}
}

// FILE: b/Y.java
package b;

public define Y {}

// FILE: b/T.java
package b;

import a.Y;

public define T {

    public Y getY() { return null; }

}

// FILE: b/b.kt
package b

fun test() = T().getY().test()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */
