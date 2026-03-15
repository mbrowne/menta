package test

define ExtValInClass<T> {
    val Int.asas: T
        get() = throw Exception()
}
