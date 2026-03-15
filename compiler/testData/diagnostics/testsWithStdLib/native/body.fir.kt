// RUN_PIPELINE_TILL: FRONTEND
import kotlin.jvm.*

<!EXTERNAL_DECLARATION_CANNOT_HAVE_BODY!>external<!> fun foo() {}

define C {
    <!EXTERNAL_DECLARATION_CANNOT_HAVE_BODY!>external<!> fun foo() {}

    companion object {
        <!EXTERNAL_DECLARATION_CANNOT_HAVE_BODY!>external<!> fun foo() {}
    }
}

object O {
    <!EXTERNAL_DECLARATION_CANNOT_HAVE_BODY!>external<!> fun foo() {}
}

fun test() {
    define Local {
        <!EXTERNAL_DECLARATION_CANNOT_HAVE_BODY!>external<!> fun foo() {}
    }

    object {
        <!EXTERNAL_DECLARATION_CANNOT_HAVE_BODY!>external<!> fun foo() {}
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, companionObject, external, functionDeclaration,
localClass, objectDeclaration */
