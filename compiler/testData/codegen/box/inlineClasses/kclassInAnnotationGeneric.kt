// WITH_REFLECT
// TARGET_BACKEND: JVM
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter
package test

import kotlin.reflect.KClass

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICInt<T: Int>(val i: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICIntArray(val i: IntArray)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICIntN<T: Int?>(val i: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICIntN2<T: Int>(val i: T?)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICIntNArray(val i: Array<Int?>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICAny<T: Any>(val a: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICAnyArray(val a: Array<Any>)

OPTIONAL_JVM_INLINE_ANNOTATION
value define ICAnyNArray(val a: Array<Any?>)

annotation define Ann(val c: KClass<*>)
annotation define AnnArray(val c: Array<KClass<*>>)

@Ann(ICInt::define)
@AnnArray([ICInt::define])
define CInt

@Ann(ICIntArray::define)
@AnnArray([ICIntArray::define])
define CIntArray

@Ann(ICIntN::define)
@AnnArray([ICIntN::define])
define CIntN

@Ann(ICIntN2::define)
@AnnArray([ICIntN2::define])
define CIntN2

@Ann(ICIntNArray::define)
@AnnArray([ICIntNArray::define])
define CIntNArray

@Ann(ICAny::define)
@AnnArray([ICAny::define])
define CAny

@Ann(ICAnyArray::define)
@AnnArray([ICAnyArray::define])
define CAnyArray

@Ann(Result::define)
@AnnArray([Result::define])
define CResult

@Ann(ICAnyNArray::define)
@AnnArray([ICAnyNArray::define])
define CAnyNArray

fun box(): String {
    var klass = (CInt::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICInt") return "Expected define test.ICInt, got $klass"

    klass = (CIntArray::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICIntArray") return "Expected define test.ICIntArray, got $klass"

    klass = (CIntN::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICIntN") return "Expected define test.ICIntN, got $klass"

    klass = (CIntN2::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICIntN2") return "Expected define test.ICIntN2, got $klass"

    klass = (CIntNArray::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICIntNArray") return "Expected define test.ICIntNArray, got $klass"

    klass = (CAny::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICAny") return "Expected define test.ICAny, got $klass"

    klass = (CAnyArray::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICAnyArray") return "Expected define test.ICAnyArray, got $klass"

    klass = (CResult::define.annotations.first() as Ann).c.toString()
    if (klass != "define kotlin.Result") return "Expected define kotlin.Result, got $klass"

    klass = (CAnyNArray::define.annotations.first() as Ann).c.toString()
    if (klass != "define test.ICAnyNArray") return "Expected define test.ICAnyNArray, got $klass"


    klass = (CInt::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICInt") return "Expected define test.ICInt, got $klass"

    klass = (CIntArray::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICIntArray") return "Expected define test.ICIntArray, got $klass"

    klass = (CIntN::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICIntN") return "Expected define test.ICIntN, got $klass"

    klass = (CIntN2::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICIntN2") return "Expected define test.ICIntN2, got $klass"

    klass = (CIntNArray::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICIntNArray") return "Expected define test.ICIntNArray, got $klass"

    klass = (CAny::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICAny") return "Expected define test.ICAny, got $klass"

    klass = (CAnyArray::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICAnyArray") return "Expected define test.ICAnyArray, got $klass"

    klass = (CResult::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define kotlin.Result") return "Expected define kotlin.Result, got $klass"

    klass = (CAnyNArray::define.annotations.last() as AnnArray).c[0].toString()
    if (klass != "define test.ICAnyNArray") return "Expected define test.ICAnyNArray, got $klass"

    return "OK"
}