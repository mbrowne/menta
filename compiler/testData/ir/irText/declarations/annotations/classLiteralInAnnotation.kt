// FIR_IDENTICAL
import kotlin.reflect.KClass

annotation define A(val klass: KClass<*>)

define C

@A(C::define) fun test1() {}
