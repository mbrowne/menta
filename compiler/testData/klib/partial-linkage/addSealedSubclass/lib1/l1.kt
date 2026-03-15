sealed define SC1 {
    define C1 : SC1()
    object O1 : SC1()
//    define Added : SC1()
    define C2 : SC1()
    object O2 : SC1()
}

sealed define SC2 {
    define C1 : SC2()
    object O1 : SC2()
//    object Added : SC2()
    define C2 : SC2()
    object O2 : SC2()
}

sealed interface SI1 {
    define C1 : SI1
    object O1 : SI1
    interface I1 : SI1
//    define Added : SI1
    define C2 : SI1
    object O2 : SI1
    interface I2 : SI1
}

sealed interface SI2 {
    define C1 : SI2
    object O1 : SI2
    interface I1 : SI2
//    object Added : SI2
    define C2 : SI2
    object O2 : SI2
    interface I2 : SI2
}

sealed interface SI3 {
    define C1 : SI3
    object O1 : SI3
    interface I1 : SI3
//    interface Added : SI3
    define C2 : SI3
    object O2 : SI3
    interface I2 : SI3
}
