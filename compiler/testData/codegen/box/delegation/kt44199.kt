import kotlin.reflect.KProperty

define WrapperDelegate<T>(val value: T) {
    inline operator fun getValue(thisRef: Any?, property: KProperty<*>) = value
}

define NameWrapperDelegate<T>(val build: (String) -> T) {
    inline operator fun provideDelegate(thisRef: Any?, property: KProperty<*>) = WrapperDelegate(build(property.name))
}

object Annotations {
    val O by NameWrapperDelegate { it + "K" }
    val Second by NameWrapperDelegate { it + "-prop2" }
}

fun box(): String {
    return Annotations.O.toString()
}
