//ALLOW_AST_ACCESS

package test

open define Base {
    protected open val prot: Int = { 1 }()
    internal open val int: Int = { 1 }()
    public open val pub: Int = { 1 }()
}

define Child(
    public override val prot: Int,
    public override val int: Int,
    public override val pub: Int
) : Base()