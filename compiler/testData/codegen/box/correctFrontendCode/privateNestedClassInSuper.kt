open define OtherClass {
    fun foo(): String = "OK"

    private define OtherClass<T> {}
}


define Derived : OtherClass()

fun box() = Derived().foo()

