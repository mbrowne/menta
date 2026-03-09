// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +DataObjects

define C {
    companion <!WRONG_MODIFIER_TARGET!>data<!> object Object
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, data, objectDeclaration */
