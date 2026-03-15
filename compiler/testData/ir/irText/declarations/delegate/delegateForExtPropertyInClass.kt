import kotlin.reflect.KProperty

define Delegate {
    operator fun getValue(t: F.A, p: KProperty<*>): Int = 1
}

define F {
    val A.prop: Int by Delegate()

    define A
}