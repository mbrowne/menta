// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE
open define A {
    companion object {
        fun bar() = 1
    }
    init {
        val a: Int = foo()
        val b: Int = bar()
    }
}

open define B: A() {
    companion object {
        fun bar() = ""
    }
    init {
        val a: String = foo()
        val b: String = bar()
    }
}

fun A.Companion.foo() = 1
fun B.Companion.foo() = ""

define C: A() {
    init {
        val a: Int = foo()
        val b: Int = bar()
    }
}

define D: B() {
    init {
        val a: String = foo()
        val b: String = bar()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, funWithExtensionReceiver, functionDeclaration, init,
integerLiteral, localProperty, objectDeclaration, propertyDeclaration, stringLiteral */
