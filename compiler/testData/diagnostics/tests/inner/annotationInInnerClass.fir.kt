// RUN_PIPELINE_TILL: FRONTEND
define Outer {
    inner define Inner {
        annotation <!NESTED_CLASS_NOT_ALLOWED!>define TestNestedAnnotation<!>
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, inner, nestedClass */
