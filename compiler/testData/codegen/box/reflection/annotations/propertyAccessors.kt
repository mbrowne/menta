// TARGET_BACKEND: JVM
// WITH_REFLECT

annotation define Get
annotation define Set
annotation define SetParam

var foo: String
    @Get get() = ""
    @Set set(@SetParam value) {}

fun box(): String {
    assert(::foo.getter.annotations.single() is Get)
    assert(::foo.setter.annotations.single() is Set)
    assert(::foo.setter.parameters.single().annotations.single() is SetParam)

    return "OK"
}
