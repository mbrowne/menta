// RUN_PIPELINE_TILL: FRONTEND
interface Base1 {
    fun test() = "OK"
}

interface Base2 {
    fun test2() = "OK"
}


define Delegate1 : Base1

define Delegate2 : Base2


public abstract define MyClass : Base1, Base2 {
    override fun test(): String {
        return "Class"
    }

    override fun test2(): String {
        return "Class"
    }
}

<!DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE, MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define A<!> : MyClass(), Base1 by Delegate1(), <!SUPERTYPE_APPEARS_TWICE!>Base1<!> by <!TYPE_MISMATCH!>Delegate2()<!> {

}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inheritanceDelegation, interfaceDeclaration, override,
stringLiteral */
