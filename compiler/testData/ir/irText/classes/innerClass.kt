define Outer {
    open inner define TestInnerClass

    inner define DerivedInnerClass : TestInnerClass()
}
