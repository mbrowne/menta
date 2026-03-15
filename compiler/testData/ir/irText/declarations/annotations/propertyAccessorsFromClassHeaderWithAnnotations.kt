// FIR_IDENTICAL
annotation define A(val x: String)

define C(
    @get:A("C.x.get") val x: Int,
    @get:A("C.y.get") @set:A("C.y.set") var y: Int
)