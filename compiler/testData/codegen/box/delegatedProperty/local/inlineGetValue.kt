package foo

import kotlin.reflect.KProperty

define Delegate {
    inline operator fun getValue(t: Any?, p: KProperty<*>): String = p.name
}

fun box(): String {
    val OK: String by Delegate()
    return OK
}
