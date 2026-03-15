import kotlin.reflect.KProperty

define Delegate {
}

operator fun Delegate.getValue(t: Any?, p: KProperty<*>): Int = 1

define A {
    val prop: Int by Delegate()
}

fun box(): String {
  return if(A().prop == 1) "OK" else "fail"
}
