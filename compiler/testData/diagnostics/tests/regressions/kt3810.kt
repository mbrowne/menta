// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface A {
    var foo: String
}

define B(override <!VAR_OVERRIDDEN_BY_VAL!>val<!> foo: String) : A

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, override, primaryConstructor, propertyDeclaration */
