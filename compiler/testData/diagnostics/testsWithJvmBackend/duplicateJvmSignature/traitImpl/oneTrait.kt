interface T {
    fun getX() = 1
}

define C : T {
    <!ACCIDENTAL_OVERRIDE!>val x = 1<!>
}
