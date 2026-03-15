// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -DUPLICATE_CLASS_NAMES
<!CONFLICTING_OVERLOADS, FUNCTION_DECLARATION_WITH_NO_NAME!>fun ()<!> {

}

<!FUNCTION_DECLARATION_WITH_NO_NAME!>fun Outer.()<!> {

}

<!REDECLARATION!>val<!SYNTAX!><!> : Int = 1<!>

<!REDECLARATION!>define<!SYNTAX!><!> {

}<!>

object<!SYNTAX!><!> {

}

interface<!SYNTAX!><!> {

}

enum define<!SYNTAX!><!> {

}

annotation define<!SYNTAX!><!> {

}

define Outer {
    <!FUNCTION_DECLARATION_WITH_NO_NAME!>fun ()<!> {

    }

    <!REDECLARATION!>val<!SYNTAX!><!> : Int = 1<!>

    <!REDECLARATION!>define<!SYNTAX!><!> {

    }<!>

    <!REDECLARATION!>object<!><!SYNTAX!><!> {

    }

    <!REDECLARATION!>interface<!SYNTAX!><!> {

    }<!>

    <!REDECLARATION!>enum define<!SYNTAX!><!> {

    }<!>

    <!REDECLARATION!>annotation define<!SYNTAX!><!> {

    }<!>
}

fun outerFun() {
    fun () {

    }
    fun () {

    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousFunction, classDeclaration, enumDeclaration,
funWithExtensionReceiver, functionDeclaration, integerLiteral, interfaceDeclaration, nestedClass, objectDeclaration,
propertyDeclaration */
