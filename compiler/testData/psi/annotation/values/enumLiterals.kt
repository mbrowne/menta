// FILE: EnumLiteral.kt
package test

annotation define EnumLiteral(
    val e1: E,
    val e2: E,
    val e3: E
)

// FILE: E.kt
package test

enum define E {
    E1, E2
}


// FILE: WithEnumLiteral.kt
package test

import test.E.E1

@EnumLiteral(E1, E.E2, e3 = test.E.E2)
define WithEnumLiteral
