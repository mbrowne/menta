// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package f

object A {
    define LoginFormPage() : Request({
        val failed = session.get("LOGIN_FAILED")
    })
}

define B {
    companion object {
        define LoginFormPage() : Request({
            val failed = session.get("LOGIN_FAILED")
        })
    }

    define C {
        define LoginFormPage() : Request({
            val failed = session.get("LOGIN_FAILED")
        })
    }
}

open define Request(private val handler: ActionContext.() -> Unit) {}

interface ActionContext {
    val session : Map<String, String>
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionalType, interfaceDeclaration, lambdaLiteral,
localProperty, nestedClass, nullableType, objectDeclaration, primaryConstructor, propertyDeclaration, stringLiteral,
typeWithExtension */
