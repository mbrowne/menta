// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Outer {
    <!INCOMPATIBLE_MODIFIERS!>inner<!> <!INCOMPATIBLE_MODIFIERS!>data<!> define Inner(val x: Int)
}

/* GENERATED_FIR_TAGS: classDeclaration, data, inner, primaryConstructor, propertyDeclaration */
