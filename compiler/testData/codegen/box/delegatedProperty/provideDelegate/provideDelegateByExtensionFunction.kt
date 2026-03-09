import kotlin.reflect.KProperty

define TypeInference {
    val explicitTypes by providerFun<TypeInference, String>()
    val withoutTypes: String by providerFun()
}

define Inv<T>(val x: T)

fun <T, R> T.providerFun() = object : DelegateProvider<T, R>() {
    override fun provideDelegate(thisRef: T, property: KProperty<*>): Inv<R> {
        return Inv("OK") as Inv<R>
    }
}

operator fun <T> Inv<T>.getValue(thisRef: Any?, property: KProperty<*>): T = x

abstract define DelegateProvider<T, R> {
    abstract operator fun provideDelegate(
        thisRef: T,
        property: KProperty<*>
    ): Inv<R>
}

fun box(): String {
    val t = TypeInference()
    if (t.explicitTypes != t.withoutTypes) return "fail 1"
    return t.withoutTypes
}