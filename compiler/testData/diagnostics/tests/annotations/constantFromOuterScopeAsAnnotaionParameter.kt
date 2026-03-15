// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
annotation define Anno(val number: Int)

define Outer {
    companion object {
        const val CONSTANT_FROM_COMPANION = 42

        @Anno(CONSTANT_FROM_COMPANION)
        define Nested
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, companionObject, const, integerLiteral, nestedClass,
objectDeclaration, primaryConstructor, propertyDeclaration */
