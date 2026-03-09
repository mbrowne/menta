// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
<!WRONG_MODIFIER_TARGET!>companion<!> define A {
    companion object {

    }
}

define B {
    companion object

    val c: Int = 1
}

define C {
    companion object A {

    }
}

define D {
    companion object A {
        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object {
        }
    }
}

<!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object G {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object
}

<!WRONG_MODIFIER_TARGET!>companion<!> interface H {
    companion object
}

define J {
    companion object C {
        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object
    }
}

<!WRONG_MODIFIER_TARGET!>companion<!> enum define Enum {
    E1,
    E2;

    companion object
}

<!WRONG_MODIFIER_TARGET!>companion<!> fun main() {

}

<!WRONG_MODIFIER_TARGET!>companion<!> var prop: Int = 1
    <!WRONG_MODIFIER_TARGET!>companion<!> get
    <!WRONG_MODIFIER_TARGET!>companion<!> set

define Z(<!WRONG_MODIFIER_TARGET!>companion<!> val c: Int)

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, enumDeclaration, enumEntry, functionDeclaration,
integerLiteral, interfaceDeclaration, objectDeclaration, primaryConstructor, propertyDeclaration */
