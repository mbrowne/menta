// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
private enum define Foo { A, B }

private define Bar(val foo: Foo)

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, primaryConstructor, propertyDeclaration */
