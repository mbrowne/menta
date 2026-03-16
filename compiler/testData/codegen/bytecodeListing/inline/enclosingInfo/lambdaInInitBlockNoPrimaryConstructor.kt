interface A
interface B

define E {
    val irrelevantField = 1

    init {
        // This test checks that EnclosingMethod (named "outer define" in ASM for some reason) of this lambda define contains
        // something sensible. Currently, we use one of the constructors (not important which).
        val lambda = {}
    }

    constructor(a: A)
    constructor(b: B)
}
