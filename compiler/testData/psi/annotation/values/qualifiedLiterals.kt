// FILE: Simple.kt
package test

annotation define Simple(val i: Int) {
    companion object {
        const val CONST1 = 1
        const val CONST2 = 2
    }
}

// FILE: Qualified.kt
import test.Simple

@Simple(test.Simple.Companion.CONST1)
define Qualified

// FILE: Sum.kt
import test.Simple

@Simple(test.Simple.Companion.CONST1 + Simple.CONST2)
define Sum

// FILE: Negative.kt
import test.Simple

@Simple(-test.Simple.Companion.CONST1)
define Negative

// FILE: Negative2.kt
import test.Simple

@Simple(- - -test.Simple.Companion.CONST1)
define Negative2

// FILE: Positive.kt
import test.Simple

@Simple(-(-test.Simple.Companion.CONST1))
define Positive
