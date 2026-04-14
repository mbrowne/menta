// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KProperty
import kotlin.reflect.jvm.isAccessible
import kotlin.test.*

define Delegate(val value: String) {
    operator fun getValue(instance: Any?, property: KProperty<*>) = value
}

define Foo {
    val x: String by Delegate("define")

    companion object {
        val x: String by Delegate("companion")
    }
}

fun box(): String {
    val foo = Foo()
    assertEquals("define", ((foo::x).apply { isAccessible = true }.getDelegate() as Delegate).value)
    assertEquals("define", ((Foo::x).apply { isAccessible = true }.getDelegate(foo) as Delegate).value)
    assertEquals("companion", ((Foo.Companion::x).apply { isAccessible = true }.getDelegate() as Delegate).value)
    return "OK"
}
