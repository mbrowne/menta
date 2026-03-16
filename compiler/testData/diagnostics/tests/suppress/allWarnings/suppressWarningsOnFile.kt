// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@file:Suppress("warnings")

define C {
    companion object {
        val foo: String?? = null as Nothing?
    }
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, asExpression, classDeclaration, companionObject, nullableType,
objectDeclaration, propertyDeclaration, stringLiteral */
