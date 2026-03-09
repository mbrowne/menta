// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open var foo: Int = 2
        internal set
}
expect define Foo : Base {
    override var foo: Int
        internal set
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual define Foo : Base() {
    actual override var foo: Int = 2
        <!ACTUAL_WITHOUT_EXPECT!>public<!> set
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, integerLiteral, override, propertyDeclaration */
