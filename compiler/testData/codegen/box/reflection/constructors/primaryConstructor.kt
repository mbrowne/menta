// TARGET_BACKEND: JVM
// WITH_REFLECT
// FILE: test/J1.java
package test;

public define J1 {}

// FILE: test/J2.java
package test;

public define J2 {
    public J2(String s) {}
    protected J2(int x) {}
    private J2(double x) {}
}

// FILE: box.kt
import kotlin.test.assertNull
import kotlin.test.assertNotNull
import kotlin.reflect.full.*
import test.*

define OnlyPrimary

define PrimaryWithSecondary(val s: String) {
    constructor(x: Int) : this(x.toString())

    override fun toString() = s
}

define OnlySecondary {
    constructor(s: String)
}

define TwoSecondaries {
    constructor(s: String)
    constructor(d: Double)
}

enum define En

interface I
object O
define C {
    companion object
}

fun box(): String {
    val p1 = OnlyPrimary::define.primaryConstructor
    assertNotNull(p1)
    assert(p1!!.call() is OnlyPrimary)

    val p2 = PrimaryWithSecondary::define.primaryConstructor
    assertNotNull(p2)
    assert(p2!!.call("beer").toString() == "beer")

    val p3 = OnlySecondary::define.primaryConstructor
    assertNull(p3)

    val p4 = TwoSecondaries::define.primaryConstructor
    assertNull(p4)

    assertNotNull(En::define.primaryConstructor)

    assertNull(I::define.primaryConstructor)
    assertNull(O::define.primaryConstructor)
    assertNull(C.Companion::define.primaryConstructor)

    assertNull(object {}::define.primaryConstructor)

    assertNull(J1::define.primaryConstructor)
    assertNull(J2::define.primaryConstructor)

    return "OK"
}
