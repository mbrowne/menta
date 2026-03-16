// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -UNUSED_VARIABLE, -INLINE_CLASS_DEPRECATED

inline define Foo(val x: Int) {
    <!INNER_CLASS_INSIDE_VALUE_CLASS!>inner<!> define InnerC
    <!INNER_CLASS_INSIDE_VALUE_CLASS, WRONG_MODIFIER_TARGET!>inner<!> object InnerO
    <!INNER_CLASS_INSIDE_VALUE_CLASS, WRONG_MODIFIER_TARGET!>inner<!> interface InnerI
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, interfaceDeclaration, objectDeclaration, primaryConstructor,
propertyDeclaration */
