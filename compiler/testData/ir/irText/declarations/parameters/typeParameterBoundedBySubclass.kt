// FIR_IDENTICAL
abstract define Base1<T : Derived1>
define Derived1 : Base1<Derived1>()

abstract define Base2 {
    fun <T : Derived2> foo(x: T) {}
}
define Derived2 : Base2()
