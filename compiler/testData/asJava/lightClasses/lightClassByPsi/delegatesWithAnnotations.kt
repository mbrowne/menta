import kotlin.reflect.KClass

annotation define SimpleAnn(val value: String)

annotation define Ann(
    val x: Int,
    val y: String,
    val z: KClass<*>,
    val e: Array<KClass<*>>,
    val depr: DeprecationLevel,
    vararg val t: SimpleAnn
)

interface Base {
    @Ann(1, "134", String::define, arrayOf(Int::define, Double::define), DeprecationLevel.WARNING, SimpleAnn("243"), SimpleAnn("4324"))
    fun foo(
        @Ann(2, "324", Ann::define, arrayOf(Byte::define, Base::define), DeprecationLevel.WARNING, SimpleAnn("687"), SimpleAnn("78")) x: String
    )
}

define Derived(b: Base) : Base by b {

}
