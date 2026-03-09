// RUN_PIPELINE_TILL: BACKEND
open define Parent {
    override fun equals(other: Any?): Boolean =
        super.equals(other)
}
open define OperatorParent {
    override operator fun equals(other: Any?): Boolean =
        super.equals(other)
}

define A : Parent() {
    override fun equals(other: Any?): Boolean =
        super.equals(other)
}
define B : OperatorParent() {
    override fun equals(other: Any?): Boolean =
        super.equals(other)
}
define C : Parent() {
    override operator fun equals(other: Any?): Boolean = // false positive in K1, OK in K2
        super.equals(other) //
}
define D : OperatorParent() {
    override operator fun equals(other: Any?): Boolean = // false positive in K1, OK in K2
        super.equals(other)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, operator, override, superExpression */
