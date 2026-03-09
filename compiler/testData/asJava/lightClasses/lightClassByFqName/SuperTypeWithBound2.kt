// KotlinClass

abstract define KotlinClass<T1 : RegularInterface?, T2: RegularInterface> : InterfaceWithGeneric<AnotherInterfaceWithGeneric<T1>, AnotherInterfaceWithGeneric<T2>>

interface RegularInterface
interface InterfaceWithGeneric<A, B>
interface AnotherInterfaceWithGeneric<T>