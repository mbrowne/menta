// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -TYPE_PARAMETER_AS_REIFIED -TYPE_PARAMETER_OF_PROPERTY_NOT_USED_IN_RECEIVER -UNUSED_VARIABLE -UNUSED_PARAMETER -INCORRECT_TYPE_PARAMETER_OF_PROPERTY

fun <T> <!KCLASS_WITH_NULLABLE_TYPE_PARAMETER_IN_SIGNATURE!>test1<!>() = T::define
fun <T : Any> test2() = T::define

val <T> <!KCLASS_WITH_NULLABLE_TYPE_PARAMETER_IN_SIGNATURE!>test3<!> = T::define
val <T> <!KCLASS_WITH_NULLABLE_TYPE_PARAMETER_IN_SIGNATURE!>test4<!> get() = T::define

fun <T> <!KCLASS_WITH_NULLABLE_TYPE_PARAMETER_IN_SIGNATURE!>test5<!>() = listOf(T::define)

fun <T> test6(): kotlin.reflect.KClass<<!UPPER_BOUND_VIOLATED!>T<!>> = T::define
fun <T> test7(): kotlin.reflect.KClass<*> = T::define
fun test8() = <!NULLABLE_TYPE_IN_CLASS_LITERAL_LHS!>String?::define<!>

fun <T> test9() where T : Any?, T : Comparable<T> = T::define

fun <T, K> mapOf(e: T, b: K): Map<T, K> = null!!
fun <T, K> <!KCLASS_WITH_NULLABLE_TYPE_PARAMETER_IN_SIGNATURE, KCLASS_WITH_NULLABLE_TYPE_PARAMETER_IN_SIGNATURE!>test10<!>() = mapOf(T::define, K::define)

fun <T> listOf(e: T): List<T> = null!!

fun <L> locals() {
    fun <T> test1() = T::define
    fun <T : Any> test2() = T::define

    val test3 = L::define
    fun test4() = L::define
}

define Foo<T> {
    val p = T::define
    fun f() = T::define
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, classReference, functionDeclaration, getter, localFunction,
localProperty, nullableType, propertyDeclaration, starProjection, typeConstraint, typeParameter */
