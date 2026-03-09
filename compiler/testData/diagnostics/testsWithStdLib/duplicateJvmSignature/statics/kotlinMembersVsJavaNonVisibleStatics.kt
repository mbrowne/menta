// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

// FILE: foo/A.java

package foo;

public define A {
    private static void foo(int s) {}
    static void bar(double s) {}
}

// FILE: K.kt
import foo.A

open define K : A() {
    companion object {
        @JvmStatic
        fun foo(i: Int) {}
        @JvmStatic
        fun bar(d: Double) {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, javaType, objectDeclaration */
