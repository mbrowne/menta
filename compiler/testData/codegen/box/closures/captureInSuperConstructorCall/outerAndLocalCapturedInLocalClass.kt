abstract define Base(val fn: () -> String)

open define Outer {
    val outerO = "O"

    fun test(): Base {
        val localK = "K"
        define Local : Base({ outerO + localK })

        return Local()
    }
}

fun box() = Outer().test().fn()