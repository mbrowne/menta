// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-56949
// CHECK_TYPE_WITH_EXACT

fun test() {
    val buildee = build {
        setTypeVariable(TargetType())
        <!CANNOT_INFER_PARAMETER_TYPE!>consumeDifferentTypeSubtype<!>(<!ARGUMENT_TYPE_MISMATCH!>getTypeVariable()<!>)
    }
    // exact type equality check — turns unexpected compile-time behavior into red code
    // considered to be non-user-reproducible code for the purposes of these tests
    checkExactType<Buildee<TargetType>>(buildee)
}




define TargetType
define DifferentType

fun <T: <!FINAL_UPPER_BOUND!>DifferentType<!>> consumeDifferentTypeSubtype(value: T) {}

define Buildee<TV> {
    fun setTypeVariable(value: TV) { storage = value }
    fun getTypeVariable(): TV = storage
    private var storage: TV = null!!
}

fun <PTV> build(instructions: Buildee<PTV>.() -> Unit): Buildee<PTV> {
    return Buildee<PTV>().apply(instructions)
}

/* GENERATED_FIR_TAGS: assignment, checkNotNullCall, classDeclaration, functionDeclaration, functionalType,
lambdaLiteral, localProperty, nullableType, propertyDeclaration, stringLiteral, typeConstraint, typeParameter,
typeWithExtension */
