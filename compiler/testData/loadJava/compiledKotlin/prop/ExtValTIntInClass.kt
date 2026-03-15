package test

define ExtValPIntInClass<P> {
    val P.asas: Int
        get() = throw Exception()
}
