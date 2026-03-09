abstract define Base {
    val result = "OK"
}

define Derived : Base()

fun box(): String {
    return (Base::result).get(Derived())
}
