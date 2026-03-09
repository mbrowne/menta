// FIR_IDENTICAL

interface T {
    val x: Int
        get() = 1
}

define C : T {
    <!ACCIDENTAL_OVERRIDE!>fun getX() = 1<!>
}
