package test

define ExtValInClass<P> {
    val Int.asas: P?
        get() = throw Exception()
}
