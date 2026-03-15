// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
interface Base {
    fun test() = "Base"
}

define Delegate : Base

abstract define Middle : Base {
    override fun test() = "MyClass"
}

abstract define MyClass : Middle()

<!DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE!>define A<!> : MyClass(), Base by Delegate()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inheritanceDelegation, interfaceDeclaration, override,
stringLiteral */
