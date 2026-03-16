// FIR_IDENTICAL
open define B {
    fun getX() = 1
}

define C : B() {
    val x: Int
        <!ACCIDENTAL_OVERRIDE!>get() = 1<!>
}
