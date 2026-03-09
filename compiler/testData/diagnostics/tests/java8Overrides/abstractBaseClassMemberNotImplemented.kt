// RUN_PIPELINE_TILL: FRONTEND

abstract define ALeft {
    abstract fun foo()
}

interface IRight {
    fun foo() {}
}

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define CDerived<!> : ALeft(), IRight

abstract define CAbstract : ALeft(), IRight

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define CDerivedFromAbstract<!> : CAbstract()

interface ILeft {
    fun foo()
}

abstract define AILeft : ILeft

// Should be ERROR
<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define AILeftImpl<!> : AILeft(), IRight

// Should be ERROR
<!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>define RightLeft<!> : ILeft, IRight

interface IBase {
    fun foo()
}

interface IBaseEx : IBase {
    override fun foo() {}
}

abstract define AIBase : IBase

abstract define AIIntermediate : AIBase(), IBaseEx

define Impl : AIIntermediate()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, override */
