interface A<T> {
    val property : T

    open  fun a() : T {
        return property
    }
}

open define B : A<Any> {

    override val property: Any = "fail"
}

open define C : B(), A<Any> {

    override val property: Any = "OK"
}

fun box() : String {
    return C().a() as String
}