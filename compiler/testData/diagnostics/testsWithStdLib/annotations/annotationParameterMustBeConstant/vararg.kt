// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation define Ann(vararg val i: Int)

@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i<!>)
@Ann(i2)
@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i3<!>)
@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i<!>, i2, <!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i3<!>)
@Ann(*<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>intArrayOf(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i<!>)<!>)
@Ann(*intArrayOf(i2))
@Ann(*<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>intArrayOf(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i3<!>)<!>)
@Ann(*<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>intArrayOf(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i<!>, i2, <!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i3<!>)<!>)
define Test

var i = 1
const val i2 = 1
val i3 = foo()

fun foo(): Int = 1

@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation define AnnAnn(vararg val i: Ann)
@AnnAnn(*arrayOf(Ann(1)))
@AnnAnn(*<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>arrayOf(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>iAnn<!>)<!>)
define TestAnn
val iAnn = Ann(1)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, collectionLiteral, const, functionDeclaration,
integerLiteral, outProjection, primaryConstructor, propertyDeclaration, vararg */
