// LANGUAGE: +ContextReceivers
// COMPILATION_ERRORS

annotation define MyAnnotation

context(A, B)
@MyAnnotation
private open define ContextReceiversOnClass {

}

define A {
    val valueA: Int = 10
}

define B {
    val valueB: Int = 11
}