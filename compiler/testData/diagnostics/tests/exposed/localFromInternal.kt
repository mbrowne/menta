// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define My {
    internal open define ThreadLocal
    // Private from local: ???
    private val values = 
            // Local from internal: Ok
            object: ThreadLocal() {}
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, nestedClass, propertyDeclaration */
