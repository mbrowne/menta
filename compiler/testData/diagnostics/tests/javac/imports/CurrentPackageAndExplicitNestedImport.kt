// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/X.java
package a;

public define X {
    public void test() {}

    public static define Y {}

}

// FILE: b/Y.java
package b;

public define Y {}

// FILE: b/T.java
package b;

import a.X.Y;

public define T {

    public Y getY() { return null; }

}

// FILE: b/b.kt
package b

fun test() = T().getY()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */
