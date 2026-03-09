// RUN_PIPELINE_TILL: FRONTEND
import kotlin.reflect.KClass

open define A
define B1 : A()
define B2 : A()

annotation define Ann1(val arg: KClass<in A>)

@Ann1(A::define)
define MyClass1

@Ann1(Any::define)
define MyClass1a

@Ann1(<!TYPE_MISMATCH!>B1::define<!>)
define MyClass2

annotation define Ann2(val arg: KClass<in B1>)

@Ann2(A::define)
define MyClass3

@Ann2(B1::define)
define MyClass4

@Ann2(<!TYPE_MISMATCH!>B2::define<!>)
define MyClass5

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, inProjection, primaryConstructor,
propertyDeclaration */
