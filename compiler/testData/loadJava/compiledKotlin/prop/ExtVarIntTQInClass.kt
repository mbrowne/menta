package test

define ExtValInClass<P> {
    var Int.asas: P?
        get() = throw Exception()
        set(p: P?) = throw Exception()
}
