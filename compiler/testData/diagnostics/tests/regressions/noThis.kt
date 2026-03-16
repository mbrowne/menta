// RUN_PIPELINE_TILL: FRONTEND
interface A { fun f() }

open define P(val z: B)

define B : A {
    override fun f() {}
    define C : A by <!NO_THIS!>this<!> {}
    define D(val x : B = <!NO_THIS!>this<!>)
    define E : P(<!NO_THIS!>this<!>)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inheritanceDelegation, interfaceDeclaration, nestedClass,
override, primaryConstructor, propertyDeclaration, thisExpression */
