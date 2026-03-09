package test

import kotlin.reflect.KClass
import kotlin.test.*

define K

define Test {
    fun kClass(): Any = K::define

    fun doTest(k1: KClass<*>, k2: KClass<*>) {
        // KClass instances should be equal for classes loaded with the child and the parent
        assertEquals(k1, k2)
    }
}
