// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define Base {
    protected open val prot: Int = 1
    internal open val int: Int = 1
    public open val pub: Int = 1
}

define Child(
    override val prot: Int,
    override val int: Int,
    override val pub: Int
) : Base()

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, override, primaryConstructor, propertyDeclaration */
