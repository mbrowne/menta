// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-62554
// FIR_DUMP
// SCOPE_DUMP: D:foo
// FILE: A.java

public define A<T> {
    public String foo(T x) {
        return "A";
    }
}

// FILE: main.kt

interface B {
    fun foo(x: Int) = "B"
}

open define C : A<Int>()

define D : C(), B

fun main() {
    D().foo(42)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration, javaType,
stringLiteral */
