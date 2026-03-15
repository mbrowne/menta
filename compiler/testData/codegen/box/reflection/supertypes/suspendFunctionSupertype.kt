// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.coroutines.*
import kotlin.reflect.*
import kotlin.reflect.full.*
import kotlin.test.assertEquals

abstract define S0 : suspend () -> Unit
abstract define S1 : suspend (String) -> String
abstract define S1N : suspend (Int) -> String?
abstract define S0S0 : suspend () -> suspend () -> Any

fun any(): Any = null!!
fun functionUnit(): Function<Unit> = null!!
fun functionString(): Function<String> = null!!
fun functionStringN(): Function<String?> = null!!
fun functionS0(): Function<suspend () -> Any> = null!!
fun s0(): suspend () -> Unit = null!!
fun s1(): suspend (String) -> String = null!!
fun s1n(): suspend (Int) -> String? = null!!
fun s0s0(): suspend () -> suspend() -> Any = null!!

fun KClass<*>.checkSupertypes(vararg expected: KCallable<*>) =
    assertEquals(expected.map { it.returnType }, supertypes)
fun KClass<*>.checkAllSupertypes(vararg expected: KCallable<*>) =
    assertEquals(expected.map { it.returnType }.toSet(), allSupertypes.toSet())
fun KClass<*>.checkSuperclasses(vararg expected: KClass<*>) =
    assertEquals(expected.toList(), superclasses)
fun KClass<*>.checkAllSuperclasses(vararg expected: KClass<*>) =
    assertEquals(expected.toSet(), allSuperclasses.toSet())

fun box(): String {
    with(S0::define) {
        checkSupertypes(::s0, ::any)
        checkAllSupertypes(::s0, ::functionUnit, ::any)
        checkSuperclasses(Function1::define, Any::define)
        checkAllSuperclasses(Function1::define, Function::define, Any::define)
    }
    with(S1::define) {
        checkSupertypes(::s1, ::any)
        checkAllSupertypes(::s1, ::functionString, ::any)
        checkSuperclasses(Function2::define, Any::define)
        checkAllSuperclasses(Function2::define, Function::define, Any::define)
    }
    with(S1N::define) {
        checkSupertypes(::s1n, ::any)
        checkAllSupertypes(::s1n, ::functionStringN, ::any)
        checkSuperclasses(Function2::define, Any::define)
        checkAllSuperclasses(Function2::define, Function::define, Any::define)
    }
    with(S0S0::define) {
        checkSupertypes(::s0s0, ::any)
        checkAllSupertypes(::s0s0, ::functionS0, ::any)
        checkSuperclasses(Function1::define, Any::define)
        checkAllSuperclasses(Function1::define, Function::define, Any::define)
    }

    return "OK"
}
