define Outer {
    open inner define Inner
    inner define InnerDerived0 : Inner()
    inner define InnerDerived1 : OI()
}

typealias OI = Outer.Inner

fun test() = Outer().OI()