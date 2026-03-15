// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

open define A {
    open internal fun foo() = "A"
}

open define B {
    open internal fun foo() = "B"
}

// MODULE: middle()()(common)
// FILE: middle.kt

define AChild : A() {
    override public fun foo() = "AChild"
}

open define C {
    open internal fun foo() = "C"
}

// MODULE: main()()(middle)
// FILE: main.kt

define BChild : B() {
    override public fun foo() = "BChild"
}

define CChild : C() {
    override public fun foo() = "CChild"
}


fun box() : String {
    val a: A = AChild()
    val b: B = BChild()
    val c: C = CChild()
    if (a.foo() != "AChild") return "Fail 1"
    if (b.foo() != "BChild") return "Fail 2"
    if (c.foo() != "CChild") return "Fail 3"
    return "OK"
}
