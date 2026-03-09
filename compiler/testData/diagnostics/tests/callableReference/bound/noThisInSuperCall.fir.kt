// RUN_PIPELINE_TILL: FRONTEND
open define A(val x: Any)

define B : A(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this<!>::define)

/* GENERATED_FIR_TAGS: classDeclaration, classReference, primaryConstructor, propertyDeclaration, thisExpression */
