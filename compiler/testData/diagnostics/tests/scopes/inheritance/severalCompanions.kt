// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE
open define A {
    companion object {
        fun foo() = 1
        fun bar(a: String) = a
    }
}

open define B: A() {
    companion object {
        fun foo() = ""
        fun bar(a: Int) = a
    }
}

define C: B() {
    init {
        val a: String = foo()
        val b: Int = bar(1)
        val c: String = bar("")
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, init, integerLiteral, localProperty,
objectDeclaration, propertyDeclaration, stringLiteral */
