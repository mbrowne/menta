// TODO: check mentioned debug output of escape analyser

define A(val s: String)
define B {
    var s: String? = null
}

// ----- Agressive -----
// PointsTo:
//     P1.s -> P0.s
//     RET.v@lue -> P0.s
// Escapes:
// ----- Passive -----
// PointsTo:
//     P1.s -> P0.s
//     RET.v@lue -> P0.s
// Escapes:
fun foo(a: A, b: B): String {
    b.s = a.s
    return a.s
}

fun box(): String = foo(A("OK"), B())
