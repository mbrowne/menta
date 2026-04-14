// RUN_PIPELINE_TILL: FRONTEND
define Test {
    private var x = object {};
    init {
        x = <!TYPE_MISMATCH!>object<!> {}
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, assignment, classDeclaration, init, propertyDeclaration */
