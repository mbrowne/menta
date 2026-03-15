// MODULE: library
// JVM_DEFAULT_MODE: disable
// FILE: a.kt
package base

annotation define Anno(val value: String)

interface A {
    @Anno("f")
    fun f(): String = ""

    @Anno("p")
    var p: String
        @Anno("get-p")
        get() = ""
        @Anno("set-p")
        set(value) {}
}

open define B : A

// MODULE: main(library)
// JVM_DEFAULT_MODE: enable
// FILE: source.kt
import base.*

interface C : A {
    override fun f(): String = ""

    override var p: String
        get() = ""
        set(value) {}
}

define D : B(), C
