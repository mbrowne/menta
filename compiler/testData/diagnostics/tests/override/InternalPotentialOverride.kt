// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1
// FILE: A.kt

open define A {
    internal open fun foo() : Int = 1
}

open define AG<T> {
    internal open fun bar(arg: T) = arg
}

// MODULE: m2(m1)
// FILE: B.kt

define B : A() {
    fun foo() : String = ""
}

define BG : AG<String>() {
    fun bar(arg: Int) = arg
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nullableType, stringLiteral, typeParameter */
