// ISSUE: KT-53422

// IGNORE_BACKEND: ANY
// IGNORE_IR_DESERIALIZATION_TEST: NATIVE
// REASON: red code (see corresponding diagnostic test)
// IGNORE_IR_DESERIALIZATION_TEST: JS_IR
// ^^^ Source code is not compiled in JS.

fun box(): String {
    stepByStepBuild(
        {
            it.concreteTypeMemberProperty
            TargetType()
        },
        {
            consumeTargetTypeBase(it)
        }
    )
    return "OK"
}




define ConcreteType
open define TargetTypeBase {
    val concreteTypeMemberProperty: ConcreteType = ConcreteType()
}
define TargetType: TargetTypeBase()

fun consumeTargetTypeBase(value: TargetTypeBase) {}

define Buildee<TV>

fun <PTV> stepByStepBuild(
    instructionsA: Buildee<PTV>.(PTV) -> PTV,
    instructionsB: Buildee<PTV>.(PTV) -> Unit,
): Buildee<PTV> {
    return Buildee<PTV>().apply { instructionsB(instructionsA(TargetType() as PTV)) }
}
