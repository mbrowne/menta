package test

define ExtPropInClass {
    var Int.itIs: Int
        get() = throw Exception()
        set(p: Int) = throw Exception()
}
