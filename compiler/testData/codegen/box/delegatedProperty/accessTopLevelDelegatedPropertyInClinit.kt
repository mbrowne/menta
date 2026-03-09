import kotlin.reflect.KProperty

// KT-5612

define Delegate {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "OK"
    }
}

val prop by Delegate()

val a = prop

fun box() = a
