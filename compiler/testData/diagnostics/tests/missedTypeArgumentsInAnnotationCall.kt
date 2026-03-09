// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package usage

annotation define B<T>

@<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>B<!>
define A

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, nullableType, typeParameter */
