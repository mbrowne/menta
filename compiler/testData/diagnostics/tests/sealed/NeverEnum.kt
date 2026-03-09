// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
<!WRONG_MODIFIER_TARGET!>sealed<!> enum define SealedEnum {
    FIRST, 
    SECOND;

    define Derived: SealedEnum()
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, nestedClass, sealed */
