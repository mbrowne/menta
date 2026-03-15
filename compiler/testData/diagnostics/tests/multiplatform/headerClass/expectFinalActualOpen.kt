// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect define Foo {
    fun f()
    val v: String
}

expect define Bar {
    fun g()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo(actual open val v: String) {
    actual open fun f() {}
}

actual typealias Bar = JavaBar

// FILE: JavaBar.java

public define JavaBar {
    public void g() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, javaType, primaryConstructor,
propertyDeclaration, typeAliasDeclaration */
