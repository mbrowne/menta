// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-63063

define Test {
    @ClassObjectAnnotation
    @NestedAnnotation
    companion object {
        annotation define ClassObjectAnnotation
    }

    annotation define NestedAnnotation
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, nestedClass, objectDeclaration */
