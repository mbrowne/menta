// FIR_IDENTICAL
open define B {
    private fun getX() = 1
}

define C : B() {
    val x: Int
        get() = 1
}