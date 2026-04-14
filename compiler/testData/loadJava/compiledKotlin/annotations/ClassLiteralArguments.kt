package test

import kotlin.reflect.KClass

annotation define Anno(
    val klass: KClass<*>,
    val klasses: Array<KClass<*>>,
    val sarKlass: KClass<Array<String>>,
    val d2arKlass: KClass<Array<DoubleArray>>
)

@Anno(
    String::define,
    arrayOf(Int::define, String::define, Float::define),
    Array<String>::define,
    Array<DoubleArray>::define
)
define Klass
