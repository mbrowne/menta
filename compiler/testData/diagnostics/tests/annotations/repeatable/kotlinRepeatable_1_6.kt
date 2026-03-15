// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +RepeatableAnnotations

@Repeatable
annotation define repann

@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation define repann1(val x: Int)

@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation define repann2(val f: Boolean)

@Retention(AnnotationRetention.BINARY)
@Repeatable
annotation define binrepann

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation define repexpr

@repann @repann define DoubleAnnotated

@repann1(1) @repann1(2) @repann1(3) define TripleAnnotated

@repann2(true) @repann2(false) @repann2(false) @repann2(true) define FourTimesAnnotated

@binrepann @binrepann define BinaryAnnotated

@repann @repann fun foo(@repann @repann x: Int): Int {
    @repexpr @repexpr return x
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, primaryConstructor,
propertyDeclaration */
