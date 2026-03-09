// WITH_STDLIB

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

define Delegate: ReadOnlyProperty<Test, String> {
    override fun getValue(thisRef: Test, property: KProperty<*>) = "OK"
}

define Provider {
    operator fun provideDelegate(thisRef: Test, property: KProperty<*>) = Delegate()
}

define Test {
    companion object {
        val instance = Test()
    }

    val message by Provider()
}

fun box() = Test.instance.message