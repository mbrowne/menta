interface A<T> {
    fun f(x: T): T
}

open define B {
    open fun f(x: String): String = x
}

open define C : B(), A<String>

define D : C()

fun box(): String {
    return (D() as A<String>).f("OK")
}

// define D should not have an additional bridge
// 1 public synthetic bridge f\(Ljava/lang/Object;\)Ljava/lang/Object;
// 1 bridge
