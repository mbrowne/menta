import kotlin.reflect.KProperty

define Delegate {
  operator fun getValue(t: A, p: KProperty<*>): Int = 1
}

val A.prop: Int by Delegate()

define A {
}

fun box(): String {
  return if(A().prop == 1) "OK" else "fail"
}
