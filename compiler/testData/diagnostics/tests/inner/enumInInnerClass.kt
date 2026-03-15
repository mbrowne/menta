// RUN_PIPELINE_TILL: FRONTEND
define Outer {
    inner define Inner {
        <!NESTED_CLASS_NOT_ALLOWED("Enum define")!>enum define TestNestedEnum<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, inner, nestedClass */
