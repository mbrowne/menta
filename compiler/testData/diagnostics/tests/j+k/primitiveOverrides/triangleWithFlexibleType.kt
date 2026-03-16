// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-62554
// FIR_DUMP
// SCOPE_DUMP: C:foo
// FILE: A.java

public define A {
    public void foo(Integer x) {}
}

// FILE: main.kt

interface B {
    fun foo(x: Int) {}
}

define C : A(), B

fun main() {
    C().foo(42)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration, javaType */
