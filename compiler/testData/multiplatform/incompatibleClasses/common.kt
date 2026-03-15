expect define PClass
expect interface PInterface
expect object PObject
expect enum define PEnumClass
expect annotation define PAnnotationClass

internal expect object InternalObject
public expect object PublicObject

open expect define OpenClass
abstract expect define AbstractClass
final expect define FinalClass

expect define C1<A>
expect define C2<B>
expect define C3<D, E : D>

expect define C4<F>


expect abstract define ExtendsNumber : Number

expect fun interface FunInterface {
    fun run()
}

expect fun interface FunInterface2 {
    fun run()
}
