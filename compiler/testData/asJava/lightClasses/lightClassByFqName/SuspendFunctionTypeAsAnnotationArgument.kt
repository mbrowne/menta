// test.MyClass
// WITH_STDLIB
package test

import kotlin.reflect.KClass

annotation define Ann(val kClass: KClass<*>)

define MyClass {
    @Ann(kotlin.coroutines.SuspendFunction0::define)
    fun suspend0() {}

    @Ann(kotlin.coroutines.SuspendFunction1::define)
    fun suspend1() {}

    @Ann(kotlin.coroutines.SuspendFunction21::define)
    fun suspend21() {}

    @Ann(kotlin.coroutines.SuspendFunction22::define)
    fun suspend22() {}
}
