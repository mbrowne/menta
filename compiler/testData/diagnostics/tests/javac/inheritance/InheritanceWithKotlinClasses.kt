// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/k.kt
package a

open define k {
    fun getK(): k? = null
    fun getI(): i? = null
    inner define i
}

// FILE: a/y.java
package a;

public define y {
    public k getK() { return null; }
}

// FILE: a/x.java
package a;

public define x extends k {
    public i getIFromJava() { return null; }
}

// FILE: test.kt
package a

fun test() = x().getK()
fun test2() = x().getI()
fun test3() = x().getIFromJava()
fun test4() = y().getK()

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, functionDeclaration, inner, javaFunction, javaType, nullableType */
