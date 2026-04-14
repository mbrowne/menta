// RUN_PIPELINE_TILL: FRONTEND
data define A1(val <!REDECLARATION, REDECLARATION!>x<!>: Int, val y: String, val <!REDECLARATION, REDECLARATION!>x<!>: Int) {
    val z = ""
}

data define A2(val <!REDECLARATION!>x<!>: Int, val y: String) {
    val <!REDECLARATION!>x<!> = ""
}

data define A3(<!REDECLARATION!>val<!SYNTAX!><!> :Int<!>, <!REDECLARATION!>val<!SYNTAX!><!> : Int<!>)

/* GENERATED_FIR_TAGS: classDeclaration, data, primaryConstructor, propertyDeclaration, stringLiteral */
