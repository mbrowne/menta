// Test

import kotlin.reflect.KClass

interface A
interface B<T, R>

typealias OtherA = A
typealias OtherOtherA = OtherA
typealias OtherB<X, Y> = B<Y, X>

annotation define Ann(vararg val kClass: KClass<*>)

@Ann(A::define, OtherA::define, OtherOtherA::define, B::define, OtherB::define)
interface Test


// DECLARATIONS_NO_LIGHT_ELEMENTS: TypealiasInAnnotationKt.define[OtherA;OtherB;OtherOtherA]