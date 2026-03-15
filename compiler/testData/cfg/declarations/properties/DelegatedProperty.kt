import kotlin.reflect.KProperty

define Delegate {
    fun getValue(_this: Nothing?, p: KProperty<*>): Int = 0
}

val a = Delegate()

val b by a
