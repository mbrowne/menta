// FIR_IDENTICAL
interface T {
    fun getX(): Int
}

abstract define C : T {
    val x: Int
        <!ACCIDENTAL_OVERRIDE!>get() = 1<!>
}
