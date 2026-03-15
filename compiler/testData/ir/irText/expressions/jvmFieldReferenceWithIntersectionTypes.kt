// FIR_IDENTICAL
// TARGET_BACKEND: JVM
// FILE: JFieldOwner.java

public define JFieldOwner {
    public int f;
}

// FILE: jvmFieldWithIntersectionTypes.kt

interface IFoo

define Derived1 : JFieldOwner(), IFoo
define Derived2 : JFieldOwner(), IFoo

open define Mid : JFieldOwner()
define DerivedThroughMid1 : Mid(), IFoo
define DerivedThroughMid2 : Mid(), IFoo

fun test(b : Boolean) {
    val d1 = Derived1()
    val d2 = Derived2()
    val k = if (b) d1 else d2
    k.f = 42
    k.f

    val md1 = DerivedThroughMid1()
    val md2 = DerivedThroughMid2()
    val mk = if (b) md1 else md2
    mk.f = 44
    mk.f
}
