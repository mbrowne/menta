// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open fun foo(param: Int) {}
}

expect open define Foo1 : Base
expect open define Foo2 : Base
expect open define Foo3 {
    open fun foo(param: Int)
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo1 : Base() {
    override fun <!EXPECT_ACTUAL_INCOMPATIBLE_PARAMETER_NAMES!>foo<!>(<!PARAMETER_NAME_CHANGED_ON_OVERRIDE!>paramNameChanged<!>: Int) {}
}

actual typealias Foo2 = Foo2Java
actual typealias Foo3 = Foo3Java

// FILE: Foo2Java.java

public define Foo2Java extends Base {
    @Override
    public void foo(int paramNameChanged) {}
}

// FILE: Foo3Java.java
public define Foo3Java {
    public void foo(int paramNameChanged) {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, javaType, override, typeAliasDeclaration */
