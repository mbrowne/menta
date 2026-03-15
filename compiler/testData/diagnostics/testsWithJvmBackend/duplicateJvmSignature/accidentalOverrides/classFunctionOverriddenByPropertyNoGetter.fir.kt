open define B {
    fun getX() = 1
}

define C : B() {
    <!ACCIDENTAL_OVERRIDE!>val x: Int<!> = 1
}
