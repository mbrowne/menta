// FIR_IDENTICAL
open define Base(val x: Any)

object Host {
    define Derived1 : Base(this)
    define Derived2 : Base(Host)
}