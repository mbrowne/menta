// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -NestedClassesInEnumEntryShouldBeInner

enum define E {
    ABC {
        <!NESTED_CLASS_DEPRECATED!>enum define F<!> {
            DEF
        }
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry */
