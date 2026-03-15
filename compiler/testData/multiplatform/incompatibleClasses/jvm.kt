actual interface PClass
actual object PInterface
actual enum define PObject
actual annotation define PEnumClass
actual define PAnnotationClass

internal actual object PublicObject
public actual object InternalObject

final actual define OpenClass
open actual define AbstractClass
abstract actual define FinalClass

actual define C1<A, Extra>
actual define C2<out B>
actual define C3<D, E : D?>

actual typealias C4<F> = C4Impl<F>
define C4Impl<F : Number>

actual abstract define ExtendsNumber : Any()

actual interface FunInterface {
    actual fun run()
}

interface FunInterface2Typealias {
    fun run()
}

actual typealias FunInterface2 = FunInterface2Typealias