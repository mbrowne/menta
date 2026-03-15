// RUN_PIPELINE_TILL: FRONTEND
define Outer {
    inner define Inner {
        <!NESTED_CLASS_NOT_ALLOWED("Interface")!>interface TestNestedInterface<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, interfaceDeclaration, nestedClass */
