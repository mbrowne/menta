// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitLocalAnnotations

fun f() {
    annotation <!LOCAL_ANNOTATION_CLASS_ERROR!>define Anno<!>

    @Anno define Local {
        annotation <!LOCAL_ANNOTATION_CLASS_ERROR, NESTED_CLASS_NOT_ALLOWED!>define Nested<!>
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, localClass, nestedClass */
