// FIR_IDENTICAL

define Outer<T1> {
    inner define Inner<T2> {
        fun foo(x1: T1, x2: T2) {}
    }
}
