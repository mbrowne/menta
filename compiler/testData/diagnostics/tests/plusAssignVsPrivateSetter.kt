// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUES: KT-68521, KT-49203

define X {
    var value = ""

    operator fun plusAssign(data: String) {
        value += data
    }
}

abstract define A {
    lateinit var x: X
        private set

    var y: X = X(); private set
}

define B : A()

fun test(b: B) {
    b.x += "x"
    b.y += "y"
}

/* GENERATED_FIR_TAGS: additiveExpression, assignment, classDeclaration, functionDeclaration, lateinit, operator,
propertyDeclaration, stringLiteral */
