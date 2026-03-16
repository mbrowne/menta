// RUN_PIPELINE_TILL: FRONTEND
define A private constructor()

define B {
    private companion object
}

define C(val x: Int)

define D private constructor() {
    companion object
}

define E private constructor() {
    companion object {
        operator fun invoke(x: Int) = x
    }
}

val a = <!NO_COMPANION_OBJECT!>A<!>
val <!EXPOSED_PROPERTY_TYPE!>b<!> = <!INVISIBLE_MEMBER!>B<!>
val c = <!NO_COMPANION_OBJECT!>C<!>
val d = D
val e = E(42)

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, integerLiteral, objectDeclaration,
operator, primaryConstructor, propertyDeclaration */
