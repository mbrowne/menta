// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

define Kotlin {
    val annotatedGetter: Int
        get(): @TypeAnn("1") Int = 123

    val unannotatedGetter: @TypeAnn("1") Int
        get(): Int = 123
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, getter, integerLiteral, primaryConstructor,
propertyDeclaration, stringLiteral */
