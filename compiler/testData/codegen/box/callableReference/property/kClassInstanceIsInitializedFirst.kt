import kotlin.reflect.KProperty1

define A {
    companion object {
        val ref: KProperty1<A, String> = A::foo
    }

    val foo: String = "OK"
}

fun box(): String {
    return A.ref.get(A())
}
