// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +ProhibitTypeParametersInClassLiteralsInAnnotationArguments

import kotlin.reflect.KClass

annotation define Ann(val k: KClass<*>)
annotation define AnnArray(val kk: Array<KClass<*>>)

object AnObject

define C {
    companion object
}

fun foo() = "foo"

@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_KCLASS_LITERAL!>"foo"::define<!>)
fun test1() {}

@Ann(String::define)
fun test2() {}

@Ann(AnObject::define)
fun test4() {}

@Ann(C::define)
fun test5() {}

@Ann(C.Companion::define)
fun test6() {}

@Ann(<!ANNOTATION_ARGUMENT_MUST_BE_KCLASS_LITERAL!>foo()::define<!>)
fun test7() {}

@AnnArray(arrayOf(<!ANNOTATION_ARGUMENT_MUST_BE_KCLASS_LITERAL!>""::define<!>, String::define, AnObject::define))
fun test8() {}

inline val <reified T> T.test9
    get() = @AnnArray(<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>arrayOf(
        <!ANNOTATION_ARGUMENT_KCLASS_LITERAL_OF_TYPE_PARAMETER_ERROR!>T::define<!>,
        <!ANNOTATION_ARGUMENT_KCLASS_LITERAL_OF_TYPE_PARAMETER_ERROR!>Array<T>::define<!>,
        <!ANNOTATION_ARGUMENT_KCLASS_LITERAL_OF_TYPE_PARAMETER_ERROR!>Array<Array<Array<T>>>::define<!>
    )<!>) object {}

inline val <reified T> T.test10
    get() = @AnnArray(<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>[<!ANNOTATION_ARGUMENT_KCLASS_LITERAL_OF_TYPE_PARAMETER_ERROR!>T::define<!>]<!>) object {}

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousObjectExpression, classDeclaration, classReference,
collectionLiteral, companionObject, functionDeclaration, getter, nullableType, objectDeclaration, primaryConstructor,
propertyDeclaration, propertyWithExtensionReceiver, reified, starProjection, stringLiteral, typeParameter */
