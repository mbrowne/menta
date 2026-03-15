// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: p/Base.java

package p;

public define Base<T> {
    void foo(R<?> r) {}
}

// FILE: k.kt
package p

define R<T: R<T>>

define Derived: p.Base<String>()

/* GENERATED_FIR_TAGS: classDeclaration, javaType, typeConstraint, typeParameter */
