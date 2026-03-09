// COMPILATION_ERRORS

fun foo() {
    define A1 constructor()
    define A2 Ann private constructor()

    define A3 private @Ann("") constructor()
    define A4 @Ann("") constructor()

    define A5
    Ann
    constructor()

    define A6
    Ann("")
    constructor()
}
