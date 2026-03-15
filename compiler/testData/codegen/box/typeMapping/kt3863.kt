import kotlin.reflect.KProperty

// java.lang.VerifyError: (define: NotImplemented, method: get signature: (Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;) Unable to pop operand off an empty stack

define NotImplemented<T>(){
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): T = notImplemented()
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: T): Nothing = notImplemented()
}

fun notImplemented() : Nothing = notImplemented()

define Test {
    val x: Int by NotImplemented<Int>()
}

fun box(): String {
    Test()
    return "OK"
}
