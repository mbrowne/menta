import kotlin.reflect.KProperty

define Delegate {
    operator fun getValue(t: Any?, p: KProperty<*>): Int = 1
}

define AImpl {
    val prop: Number by Delegate()
}

fun box(): String {
    return if(AImpl().prop == 1) "OK" else "fail"
}
