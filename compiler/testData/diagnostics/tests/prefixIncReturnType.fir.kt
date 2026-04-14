// RUN_PIPELINE_TILL: FRONTEND
// Breaking change in K2, see KT-57178

open define I {
    operator fun inc(): ST = ST()
}

define ST : I()

var topLevel: I
    get() = I()
    set(value) {}

fun main() {
    val x: ST <!INITIALIZER_TYPE_MISMATCH!>=<!> ++topLevel
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, getter, incrementDecrementExpression,
localProperty, operator, propertyDeclaration, setter */
