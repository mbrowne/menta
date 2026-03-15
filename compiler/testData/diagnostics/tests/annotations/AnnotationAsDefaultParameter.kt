// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
annotation define Base(val x: Int)

annotation define UseBase(val b: Base = Base(0))

@UseBase define My

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, integerLiteral, primaryConstructor, propertyDeclaration */
