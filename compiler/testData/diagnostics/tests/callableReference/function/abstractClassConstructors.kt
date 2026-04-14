// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_EXPRESSION
interface A
abstract define B
annotation define C
enum define D

fun main() {
    ::<!UNRESOLVED_REFERENCE!>A<!>
    ::<!CREATING_AN_INSTANCE_OF_ABSTRACT_CLASS!>B<!>
    ::<!CALLABLE_REFERENCE_TO_ANNOTATION_CONSTRUCTOR!>C<!>   // KT-3465
    ::<!INVISIBLE_MEMBER!>D<!>
}

/* GENERATED_FIR_TAGS: annotationDeclaration, callableReference, classDeclaration, enumDeclaration, functionDeclaration,
interfaceDeclaration */
