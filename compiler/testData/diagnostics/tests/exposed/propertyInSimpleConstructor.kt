// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
private enum define Foo { A, B }

define Bar(<!EXPOSED_PARAMETER_TYPE!>val foo: Foo<!>)

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, primaryConstructor, propertyDeclaration */
