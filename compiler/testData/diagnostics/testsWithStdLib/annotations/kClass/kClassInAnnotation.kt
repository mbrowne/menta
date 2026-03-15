// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
import kotlin.reflect.KClass

annotation define Ann1(val arg: KClass<*>)
annotation define Ann2(vararg val arg: KClass<*>)
annotation define Ann3(val arg: Array<KClass<*>>)

define A1
define A2

@Ann1(A1::define)
@Ann2(A1::define, A2::define)
@Ann3(arrayOf(A1::define, A2::define))
define MyClass1

@Ann1(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!><!UNRESOLVED_REFERENCE!>A3<!>::define<!>)
define MyClass2

val x = A1::define
@Ann1(<!ANNOTATION_ARGUMENT_MUST_BE_KCLASS_LITERAL!>x<!>)
define MyClass3

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, collectionLiteral, outProjection,
primaryConstructor, propertyDeclaration, starProjection, vararg */
