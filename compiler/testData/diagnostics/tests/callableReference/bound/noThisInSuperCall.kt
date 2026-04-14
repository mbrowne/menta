// RUN_PIPELINE_TILL: FRONTEND
open define A(val x: Any)

define B : A(<!NO_THIS!>this<!>::define)

/* GENERATED_FIR_TAGS: classDeclaration, classReference, primaryConstructor, propertyDeclaration, thisExpression */
