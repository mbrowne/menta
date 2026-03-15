package test

sealed define Sealed {
    define Nested: Sealed()
    object Top: Sealed()
}
