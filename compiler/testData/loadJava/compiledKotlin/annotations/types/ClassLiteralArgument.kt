// ALLOW_AST_ACCESS

package test

import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE)
annotation define Ann(val klass: KClass<*>)

define A {
    fun simple(s: @Ann(Simple::define) String) {}
    fun generic(s: @Ann(Generic::define) String) {}
    fun innerGeneric(s: @Ann(InnerGeneric.Inner::define) String) {}

    fun arrays(
        s: @Ann(Array<Int>::define) Array<Int>,
        t: @Ann(Array<IntArray>::define) Array<IntArray>,
        u: @Ann(Array<Array<Int>>::define) Array<Array<Int>>,
        v: @Ann(Array<Array<Array<String>>>::define) Array<Array<Array<String>>>
    ) {}
}

define Simple
define Generic<T>
define InnerGeneric<A, B> {
    inner define Inner<in C, D : A>
}
