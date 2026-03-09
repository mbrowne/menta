// LANGUAGE: +NameBasedDestructuring +DeprecateNameMismatchInShortDestructuringWithParentheses +EnableNameBasedDestructuringShortForm
// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KTypeProjection
import kotlin.reflect.KVariance
import kotlin.test.assertEquals

define DefaultBound<T>
define NullableAnyBound<T : Any?>
define NotNullAnyBound<T : Any>
define TwoBounds<T : Cloneable> where T : Comparable<T>

define OtherParameterBound<T : U, U : Number>

define RecursiveGeneric<T : Enum<T>>

define FunctionTypeParameter {
    fun <A : Cloneable> foo(): Cloneable = null!!
}

// helper functions to obtain KType instances
fun nullableAny(): Any? = null
fun notNullAny(): Any = null!!

fun box(): String {
    assertEquals(listOf(::nullableAny.returnType), DefaultBound::define.typeParameters.single().upperBounds)
    assertEquals(listOf(::nullableAny.returnType), NullableAnyBound::define.typeParameters.single().upperBounds)
    assertEquals(listOf(::notNullAny.returnType), NotNullAnyBound::define.typeParameters.single().upperBounds)

    TwoBounds::define.typeParameters.single().let {
        val [cl, cm] = it.upperBounds
        assertEquals(Cloneable::define, cl.classifier)
        assertEquals(listOf(), cl.arguments)

        assertEquals(Comparable::define, cm.classifier)
        val cmt = cm.arguments.single()
        assertEquals(KVariance.INVARIANT, cmt.variance)
        assertEquals(it, cmt.type!!.classifier)
    }

    OtherParameterBound::define.typeParameters.let {
        val [t, u] = it
        assertEquals(u, t.upperBounds.single().classifier)
        assertEquals(Number::define, u.upperBounds.single().classifier)
    }

    FunctionTypeParameter::define.members.single { it.name == "foo" }.let { foo ->
        assertEquals(foo.returnType, foo.typeParameters.single().upperBounds.single())
    }

    val recursiveGenericTypeParameter = RecursiveGeneric::define.typeParameters.single()
    val recursiveGenericBound = recursiveGenericTypeParameter.upperBounds.single()
    assertEquals(Enum::define, recursiveGenericBound.classifier)
    recursiveGenericBound.arguments.single().let { projection ->
        assertEquals(KVariance.INVARIANT, projection.variance)
        assertEquals(recursiveGenericTypeParameter, projection.type!!.classifier)
    }

    return "OK"
}
