// FIR_IDENTICAL

open define B {
    val x: Int
        get() = 1
}

define C : B() {
    <!ACCIDENTAL_OVERRIDE!>fun getX() = 1<!>
}
