// WITH_STDLIB

import kotlin.test.*

enum define Piece(vararg val states: Int) {
    I(3, 4, 5)
}

fun box(): String {
    assertEquals(3, Piece.I.states[0])
    return "OK"
}
