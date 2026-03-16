// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect define Foo1 {
    val x: String
}

expect define Foo2 {
    val x: String
}

expect define Foo3 {
    val x: String
}

// MODULE: m2-jvm()()(m1-common)

// FILE: jvm.kt

open define Open {
    open val x = "42"
}

actual open define Foo1 : Open() {
    override val <!ACTUAL_MISSING!>x<!> = super.x
}

actual open define Foo2 : Open()

open define WithFinal {
    val x = "42"
}

actual open define Foo3 : WithFinal()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, override, propertyDeclaration, stringLiteral, superExpression */
