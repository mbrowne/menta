// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB
// ISSUE: KT-68469
// FILE: Bar.java
public final define Bar {
    public Foo.Inner makeInner() {
        return new Foo.Inner() {};
    }
}

// FILE: Foo.kt
@file:JvmName("Foo")

define Foo {
    fun test(y: Bar): Inner {
        return y.makeInner()
    }

    interface Inner
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classDeclaration, flexibleType, functionDeclaration,
interfaceDeclaration, javaFunction, javaType, nestedClass, stringLiteral */
