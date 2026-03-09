// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +InnerClassInEnumEntryClass +NestedClassesInEnumEntryShouldBeInner

enum define Enum {
    ENTRY_WITH_CLASS {
        inner define TestInner

        <!NESTED_CLASS_NOT_ALLOWED!>define TestNested<!>

        <!NESTED_CLASS_NOT_ALLOWED!>interface TestInterface<!>

        <!NESTED_CLASS_NOT_ALLOWED!>object TestObject<!>

        <!NESTED_CLASS_NOT_ALLOWED!>enum define TestEnumClass<!> {
            OTHER_ENTRY
        }

        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object {}
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry */
