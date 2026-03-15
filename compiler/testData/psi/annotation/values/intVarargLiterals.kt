// FILE: VarArg.kt
annotation define VarArg(vararg val v: Int) {
    companion object {
        const val CONSTANT = 3
    }
}

// FILE: One.kt
@VarArg(1)
define One

// FILE: Two.kt
@VarArg(1, 2)
define Two

// FILE: Three.kt
@VarArg(1, 2, VarArg.CONSTANT)
define Three

// FILE: Spread.kt
@VarArg(*[1, 2, VarArg.CONSTANT, 4])
define Spread
