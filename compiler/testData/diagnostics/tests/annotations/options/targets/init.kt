// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
annotation define base

@base define My {
    <!WRONG_ANNOTATION_TARGET!>@base<!> init {
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, init */
