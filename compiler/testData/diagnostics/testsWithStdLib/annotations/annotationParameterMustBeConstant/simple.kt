// RUN_PIPELINE_TILL: FRONTEND
@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation define Ann(val i: Int)
annotation define AnnIA(val ia: IntArray)
annotation define AnnSA(val sa: Array<String>)

var i = 1

@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>MyClass().i<!>)
@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i<!>)
@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i2<!>)
@AnnIA(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>ia<!>)
@AnnSA(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>sa<!>)
define Test {
    val i = 1
    @Ann(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>i<!>) val i2 = 1
}

val i2 = foo()

fun foo(): Int = 1

@AnnSA(emptyArray())
define MyClass {
    val i = 1
}

val ia: IntArray = intArrayOf(1, 2)
val sa: Array<String> = arrayOf("a", "b")

annotation define Ann2

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, collectionLiteral, functionDeclaration, integerLiteral,
primaryConstructor, propertyDeclaration, stringLiteral */
