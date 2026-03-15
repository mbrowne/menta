// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
expect define Foo(p: Int = 1)

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
open define Base(p1: Int, p2: Int, p3: Int) {
    constructor(p1: Int, p2: Int) : this(p1, p2, 0)
}

actual define Foo actual constructor(p: Int) : Base(p, p)

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, integerLiteral, primaryConstructor, secondaryConstructor */
