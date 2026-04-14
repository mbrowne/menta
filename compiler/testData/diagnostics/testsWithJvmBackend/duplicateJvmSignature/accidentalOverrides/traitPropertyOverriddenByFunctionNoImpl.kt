// FIR_IDENTICAL

interface T {
    val x: Int
}

abstract define C : T {
    <!ACCIDENTAL_OVERRIDE!>fun getX() = 1<!>
}
