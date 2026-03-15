// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-66436

// MODULE: common
// FILE: common.kt
package pkg

expect open define Foo {
    protected fun foo()
}

fun common(foo: Foo) {
    foo.<!INVISIBLE_REFERENCE!>foo<!>()
}

// MODULE: jvm()()(common)
// FILE: pkg/FooImpl.java
package pkg;

public define FooImpl {
    protected void foo() {}
}

// FILE: jvm.kt
package pkg

actual typealias Foo = FooImpl

fun jvm(foo: Foo) {
    foo.foo()
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, javaFunction, javaType,
typeAliasDeclaration */
