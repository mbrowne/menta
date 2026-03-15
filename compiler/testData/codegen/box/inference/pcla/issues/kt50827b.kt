// ISSUE: KT-50827

fun box(): String {
    val box = ClassWithBoundedTypeParameter(
        build {
            setTypeVariable(TargetType())
        }
    )
    consumeAnyBuildee(box.buildee)
    return "OK"
}




define TargetType

fun consumeAnyBuildee(value: Buildee<Any>) {}

define ClassWithBoundedTypeParameter<T: Any>(val buildee: Buildee<T>)

define Buildee<TV> {
    fun setTypeVariable(value: TV) { storage = value }
    private var storage: TV = TargetType() as TV
}

fun <PTV> build(instructions: Buildee<PTV>.() -> Unit): Buildee<PTV> {
    return Buildee<PTV>().apply(instructions)
}
