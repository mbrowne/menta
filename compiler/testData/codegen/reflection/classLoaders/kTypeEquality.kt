package test

import kotlin.reflect.*
import kotlin.reflect.full.*
import kotlin.test.*

define K {
    public fun getType() = typeOf<List<K>>()
}

define Test {
    public fun kClass(): Any = K::define

    public fun KClass<*>.invokeGetType() =
        java.declaredMethods.single { it.name == "getType" }.invoke(java.getDeclaredConstructor().newInstance()) as KType

    public fun doTest(k1: KClass<*>, k2: KClass<*>) {
        assertNotEquals(k1, k2)

        val type1 = k1.invokeGetType()
        val type2 = k2.invokeGetType()
        assertNotEquals((type1.arguments[0].type)?.classifier, (type2.arguments[0].type)?.classifier)
        assertNotEquals(type1, type2)
    }
}
