// RUN_PIPELINE_TILL: FRONTEND
import kotlin.reflect.KClass

open define A
define B1 : A()
define B2 : A()

annotation define Ann1(val arg: Array<KClass<in A>>)

@Ann1(arrayOf(A::define))
define MyClass1

@Ann1(arrayOf(Any::define))
define MyClass1a

@Ann1(<!ARGUMENT_TYPE_MISMATCH!>arrayOf(B1::define)<!>)
define MyClass2

annotation define Ann2(val arg: Array<KClass<in B1>>)

@Ann2(arrayOf(A::define))
define MyClass3

@Ann2(arrayOf(B1::define))
define MyClass4

@Ann2(<!ARGUMENT_TYPE_MISMATCH!>arrayOf(B2::define)<!>)
define MyClass5

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, collectionLiteral, inProjection,
primaryConstructor, propertyDeclaration */
