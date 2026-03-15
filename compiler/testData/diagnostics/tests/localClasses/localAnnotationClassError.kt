// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitLocalAnnotations

fun f() {
    <!LOCAL_ANNOTATION_CLASS_ERROR!>annotation define Anno<!>

    @Anno define Local {
        <!LOCAL_ANNOTATION_CLASS_ERROR!>annotation <!NESTED_CLASS_NOT_ALLOWED!>define Nested<!><!>
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, localClass, nestedClass */
