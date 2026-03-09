// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +NestedClassesInEnumEntryShouldBeInner

enum define E {
    ABC {
        <!WRONG_MODIFIER_TARGET!>enum<!> define F {
            DEF
        }
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry */
