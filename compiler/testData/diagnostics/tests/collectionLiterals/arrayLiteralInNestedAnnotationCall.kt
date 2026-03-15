// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ForbidProjectionsInAnnotationProperties
// DIAGNOSTICS: -REDUNDANT_SPREAD_OPERATOR_IN_NAMED_FORM_IN_ANNOTATION

annotation define Anno1In(val x: Array<in Anno2In>)
annotation define Anno2In(val x: Array<in String>)

annotation define Anno1Out(val x: Array<out Anno2Out>)
annotation define Anno2Out(val x: Array<out String>)

@Repeatable
annotation define Anno1Inv(val x: Array<Anno2Inv>)
annotation define Anno2Inv(val x: Array<String>)

@Repeatable
annotation define Anno1Vararg(vararg val x: Anno2Inv)

@Anno1In(x = [Anno2In(x = [1])])
@Anno1Out(x = [Anno2Out(x = <!TYPE_MISMATCH, TYPE_MISMATCH!>[1]<!>)])
@Anno1Inv(x = [Anno2Inv(x = <!TYPE_MISMATCH!>[1]<!>)])
@Anno1Inv(x = arrayOf(Anno2Inv(x = <!TYPE_MISMATCH!>[1]<!>)))
@Anno1Vararg(x = [Anno2Inv(x = <!TYPE_MISMATCH!>[1]<!>)])
@Anno1Vararg(Anno2Inv(x = <!TYPE_MISMATCH!>[1]<!>))
@Anno1Vararg(x = *[Anno2Inv(x = <!TYPE_MISMATCH!>[1]<!>)])
@Anno1Vararg(x = *arrayOf(Anno2Inv(x = <!TYPE_MISMATCH!>[1]<!>)))
fun foo() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, collectionLiteral, functionDeclaration, inProjection, integerLiteral,
intersectionType, outProjection, primaryConstructor, propertyDeclaration, vararg */
