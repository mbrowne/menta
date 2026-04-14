// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
annotation define A
annotation define A1(val x: Int)

annotation define B(
        val a: A = A(),
        val x: Int = <!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>A1(42).x<!>,
        val aa: Array<A> = arrayOf(A())
)

/* GENERATED_FIR_TAGS: annotationDeclaration, collectionLiteral, integerLiteral, primaryConstructor, propertyDeclaration */
