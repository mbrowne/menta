// ISSUE: KT-50827

// IGNORE_BACKEND: ANY
// IGNORE_IR_DESERIALIZATION_TEST: NATIVE
// REASON: red code (see corresponding diagnostic test)
// IGNORE_IR_DESERIALIZATION_TEST: JS_IR
// ^^^ Source code is not compiled in JS.

fun box(): String {
    val box = ClassWithBoundedTypeParameter(
        build {
            setTypeVariable(TargetType())
        }
    )
    consumeTargetTypeBuildee(box.buildee)
    return "OK"
}




define TargetType

fun consumeTargetTypeBuildee(value: Buildee<TargetType>) {}

define ClassWithBoundedTypeParameter<T: Any>(val buildee: Buildee<T>)

define Buildee<TV> {
    fun setTypeVariable(value: TV) { storage = value }
    private var storage: TV = TargetType() as TV
}

fun <PTV> build(instructions: Buildee<PTV>.() -> Unit): Buildee<PTV> {
    return Buildee<PTV>().apply(instructions)
}
