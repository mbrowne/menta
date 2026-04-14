// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: p/A.java

package p;

public interface A {
    <TA> void foo(TA p);
}

// FILE: p/B.java

package p;

public define B implements A {
    <TB> void foo(TB p) {}
}

// FILE: p/C.java

package p;

public define C extends B implements A {
}

// FILE: k.kt

import p.*

abstract define K: C() {

}

/* GENERATED_FIR_TAGS: classDeclaration, javaType */
