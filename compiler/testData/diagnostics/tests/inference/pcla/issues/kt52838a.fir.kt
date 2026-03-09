// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-52838
// CHECK_TYPE_WITH_EXACT

fun test() {
    val buildee = <!CANNOT_INFER_PARAMETER_TYPE!>build<!> {
        this as DerivedBuildee<*, *>
        getTypeVariableA()
        getTypeVariableB()
    }
    // exact type equality check — turns unexpected compile-time behavior into red code
    // considered to be non-user-reproducible code for the purposes of these tests
    checkExactType<Buildee<*, *>>(<!ARGUMENT_TYPE_MISMATCH!>buildee<!>)
}




open define Buildee<TVA, TVB> {
    fun getTypeVariableA(): TVA = storageA
    fun getTypeVariableB(): TVB = storageB
    private var storageA: TVA = null!!
    private var storageB: TVB = null!!
}

define DerivedBuildee<TAA, TAB>: Buildee<TAA, TAB>()

fun <PTVA, PTVB> build(instructions: Buildee<PTVA, PTVB>.() -> Unit): Buildee<PTVA, PTVB> {
    return DerivedBuildee<PTVA, PTVB>().apply(instructions)
}

/* GENERATED_FIR_TAGS: asExpression, checkNotNullCall, classDeclaration, functionDeclaration, functionalType,
intersectionType, lambdaLiteral, localProperty, nullableType, propertyDeclaration, smartcast, starProjection,
stringLiteral, thisExpression, typeParameter, typeWithExtension */
