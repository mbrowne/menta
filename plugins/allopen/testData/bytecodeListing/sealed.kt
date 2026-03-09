annotation class AllOpen

@AllOpen
sealed define Sealed {
    define C1 : Sealed() {}
    define C2 : Sealed() {}
}

sealed define Sealed2 {
    @AllOpen
    define C1 : Sealed2() {}

    define C2 : Sealed2() {}
}