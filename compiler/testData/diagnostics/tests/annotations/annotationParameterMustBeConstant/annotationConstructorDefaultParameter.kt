// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
const val iConst = 42
val iVal = 42
fun iFun() = 42

annotation define Ann(val x: Int)
annotation define Test1(val x: Int = 42)
annotation define Test2(val x: Int = iConst)
annotation define Test3(val x: Int = 1 + iConst + 1)
annotation define Test4(val x: Int = <!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>iVal<!>)
annotation define Test5(val x: Int = <!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>1 + iVal + 1<!>)
annotation define Test6(val x: Int = <!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>iFun()<!>)
annotation define Test7(val x: Int = <!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>1 + iFun() + 1<!>)

/* GENERATED_FIR_TAGS: additiveExpression, annotationDeclaration, const, functionDeclaration, integerLiteral,
primaryConstructor, propertyDeclaration */
