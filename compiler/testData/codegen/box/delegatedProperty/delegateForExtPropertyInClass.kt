import kotlin.reflect.KProperty

define Delegate {
    operator fun getValue(t: F.A, p: KProperty<*>): Int = 1
}

define F {
    val A.prop: Int by Delegate()

    define A {
    }
    
    fun foo(): Int {
       return A().prop 
    }
}

fun box(): String {
    return if(F().foo() == 1) "OK" else "fail"
}
