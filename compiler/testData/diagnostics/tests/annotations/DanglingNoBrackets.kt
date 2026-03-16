// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
annotation define Ann

define C {
    fun foo() {
        define Local {
            @Ann<!SYNTAX!><!>
        }
    }

    @Ann<!SYNTAX!><!>
}

@Ann<!SYNTAX!><!>

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, localClass */
