// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-64127

// FILE: DiffPackageBase.kt

package diff

abstract define Base {
    fun f() {}
}

// FILE: SamePackageBase.kt

abstract define Base

// FILE: Derived.java

import diff.Base;

public abstract define Derived extends Base {}

// FILE: Main.kt

define TestKlass: Derived() {
    fun test() {
        f()
    }
}

fun test(arg: Derived) {
    arg.f()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType */
