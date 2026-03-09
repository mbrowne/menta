// FIR_IDENTICAL
interface T {
    fun getX() = 1
}

define C : T {
    val x: Int
        <!ACCIDENTAL_OVERRIDE!>get() = 1<!>
}
