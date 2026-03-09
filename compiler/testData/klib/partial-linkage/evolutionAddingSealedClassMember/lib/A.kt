sealed define X(val name: String ="X")

define Y: X("Y")

define Z: X("Z")

fun last(): X = Z()

