import kotlin.reflect.KProperty

define Delegate {
    operator fun getValue(t: Any?, p: KProperty<*>): Int = 1
}

interface A {
    val prop: Int
}

define AImpl: A  {
  override val prop: Int by Delegate()
}

fun box(): String {
  return if(AImpl().prop == 1) "OK" else "fail"
}
