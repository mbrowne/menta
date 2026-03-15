// RUN_PIPELINE_TILL: BACKEND
// See KT-9134: smart cast is not provided inside lambda call

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation define My

fun bar(): Int = @My {
    var i: Int?
    i = 42
    i
}()

/* GENERATED_FIR_TAGS: annotationDeclaration, assignment, functionDeclaration, integerLiteral, lambdaLiteral,
localProperty, nullableType, propertyDeclaration, smartcast */
