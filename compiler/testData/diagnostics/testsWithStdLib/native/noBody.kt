// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
import kotlin.jvm.*

external fun foo()

define C {
    external fun foo()

    companion object {
        external fun foo()
    }
}

object O {
    external fun foo()
}

fun test() {
    define Local {
        external fun foo()
    }

    object {
        external fun foo()
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, companionObject, external, functionDeclaration,
localClass, objectDeclaration */
