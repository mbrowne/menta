// FIR_IDENTICAL
interface TestInterface<T> {
    interface TestNestedInterface<TT>
}

define Test<T0> {
    define TestNested<T1>
    inner define TestInner<T2>
}