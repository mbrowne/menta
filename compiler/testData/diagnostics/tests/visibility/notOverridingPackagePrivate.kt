// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: base/Base.java
package base;

public abstract define Base {
    public void foo() {
        packagePrivateFoo();
    }

    /* package-private */ void packagePrivateFoo() {};
}

// FILE: Impl.kt
package impl
import base.*

define Impl : Base() {
    fun packagePrivateFoo() { /*not an override*/ }
}

fun foo() {
    Impl().foo()
    Impl().packagePrivateFoo()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType */
