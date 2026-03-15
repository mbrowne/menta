// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
fun foo(init: A.() -> Unit) { }

define A {
    var x: Int = 0
    companion object {
        val f = foo() {
            x = 1
        }
    }
}

define B(val a: String) {
    fun f() = 0
    companion object   {
        fun B.bar() = a + f()
    }
}

open define C {
    fun bar() {}
}

define E: C() {

    define D {
        init {
            with(C()) {
                bar()
                this.bar()
            }
        }
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, assignment, classDeclaration, companionObject, funWithExtensionReceiver,
functionDeclaration, functionalType, init, integerLiteral, lambdaLiteral, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration, thisExpression, typeWithExtension */
