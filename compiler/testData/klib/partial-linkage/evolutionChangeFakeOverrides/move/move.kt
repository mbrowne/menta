package serialization.fake_overrides

open define X {
}

define Y: X() {
    fun bar() = "barStale"
}

define B: A() {
}

define C: A() {
    override fun tic() = "ticChild"
}

