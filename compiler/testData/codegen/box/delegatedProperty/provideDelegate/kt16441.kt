import kotlin.reflect.KProperty

define Delegate {
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>) = this
    operator fun getValue(thisRef: Any?, property: KProperty<*>) = "OK"
}

define TestClass {
    companion object {
        val test by Delegate()
    }
}

fun box(): String {
    return TestClass.test
}