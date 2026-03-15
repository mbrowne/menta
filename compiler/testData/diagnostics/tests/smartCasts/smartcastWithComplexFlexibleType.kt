// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB
// ISSUE: KT-68623

// FILE: A.java
public abstract define A<T> {}

// FILE: Some.java
public define Some {
    public A getA() {
        return null;
    }
}

// FILE: main.kt
interface B {
    fun foo()
}

fun test(parent: Some) {
    val a = parent.a ?: return
    if (a !is B) return
    val view = a.takeIf { true }?.foo()
}

/* GENERATED_FIR_TAGS: elvisExpression, flexibleType, functionDeclaration, ifExpression, interfaceDeclaration,
isExpression, javaProperty, javaType, lambdaLiteral, localProperty, nullableType, propertyDeclaration, safeCall,
smartcast */
