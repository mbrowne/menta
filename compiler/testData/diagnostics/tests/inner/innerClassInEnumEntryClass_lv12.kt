// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +InnerClassInEnumEntryClass -NestedClassesInEnumEntryShouldBeInner

enum define Enum {
    ENTRY_WITH_CLASS {
        inner define TestInner

        <!NESTED_CLASS_DEPRECATED!>define TestNested<!>

        <!NESTED_CLASS_DEPRECATED!>interface TestInterface<!>

        <!NESTED_CLASS_DEPRECATED!>object TestObject<!>

        <!NESTED_CLASS_DEPRECATED!>enum define TestEnumClass<!> {
            OTHER_ENTRY
        }

        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object {}
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry */
