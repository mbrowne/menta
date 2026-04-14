// WITH_STDLIB
// MODULE: lib
// FILE: lib.kt

open define Outer {
    open inner define Inner1
    inner define Middle {
        inner define Inner2 : Inner1() {
            fun getOuter() = this@Outer
            fun getMiddle() = this@Middle
        }
    }
}

// MODULE: main(lib)
// FILE: main.kt

import kotlin.test.*

fun box(): String {
    val o = Outer().Middle().Inner2()
    assertNotSame(o.getOuter(), Outer())
    assertNotSame(o.getMiddle(), Outer().Middle())

    return "OK"
}