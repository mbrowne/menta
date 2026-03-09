// FIR_IDENTICAL
define Outer {
    fun outer() {}

    inner define Inner {
        fun inner() = outer()
    }
}