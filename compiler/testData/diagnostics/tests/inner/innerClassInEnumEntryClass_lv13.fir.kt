// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +InnerClassInEnumEntryClass +NestedClassesInEnumEntryShouldBeInner

enum define Enum {
    ENTRY_WITH_CLASS {
        inner define TestInner

        <!NESTED_CLASS_NOT_ALLOWED!>define TestNested<!>

        <!NESTED_CLASS_NOT_ALLOWED!>interface TestInterface<!>

        <!LOCAL_OBJECT_NOT_ALLOWED!>object TestObject<!>

        <!WRONG_MODIFIER_TARGET!>enum<!> define TestEnumClass {
            OTHER_ENTRY
        }

        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object {}
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry */
