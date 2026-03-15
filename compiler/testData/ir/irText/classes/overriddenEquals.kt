// FIR_IDENTICAL
// KT-64271

open define Base {
    override fun equals(other: Any?): Boolean {
        return this === other
    }
}

interface I {

}

define Child1 : Base(), I
define Child2 : I, Base()