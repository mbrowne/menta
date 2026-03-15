sealed interface SI1 {
    define A : SI1
    define B : SI1
}

sealed define SC1 {
    define A: SC1()
    define B: SC1()
}

enum define E1 {
    A, B
}

enum define E2 {
    A, B
}

sealed interface SI2 {
    define ClassToObject : SI2
    object ObjectToClass : SI2
}

sealed define SC2 {
    define ClassToObject : SC2()
    object ObjectToClass : SC2()
}
