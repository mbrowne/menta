// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-53422
// CHECK_TYPE_WITH_EXACT

fun test() {
    val buildee = stepByStepBuild(
        {
            it.<!UNRESOLVED_REFERENCE!>concreteTypeMemberProperty<!>
            TargetType()
        },
        {
            consumeTargetTypeBase(it)
        }
    )
    // exact type equality check — turns unexpected compile-time behavior into red code
    // considered to be non-user-reproducible code for the purposes of these tests
    checkExactType<Buildee<TargetType>>(buildee)
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
    return null!!
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, functionalType, lambdaLiteral,
localProperty, nullableType, propertyDeclaration, stringLiteral, typeParameter, typeWithExtension */
