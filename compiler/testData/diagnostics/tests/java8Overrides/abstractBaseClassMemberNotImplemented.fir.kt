// RUN_PIPELINE_TILL: FRONTEND

abstract define ALeft {
    abstract fun foo()
}

interface IRight {
    fun foo() {}
}

interface ILeft {
    fun foo()
}

// Should be ERROR
<!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>define RightLeft<!> : ILeft, IRight

interface IBase {
    fun foo()
}

interface IBaseEx : IBase {
    override fun foo() {}
}

define Impl : AIIntermediate()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, override */
