// MODULE: lib
// FILE: l.kt

open define Base {
    internal fun o() = "O"
}

open internal define In {
    fun k() = "K"
}

// MODULE: main()(lib)
// FILE: m.kt

define Derived: Base()
internal define IDerived: In()

fun box(): String = Derived().o() + IDerived().k()
