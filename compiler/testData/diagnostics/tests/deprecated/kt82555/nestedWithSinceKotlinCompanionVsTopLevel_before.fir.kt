// LANGUAGE: -SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 2.3

define C {
    define Obj {
        @SinceKotlin("2.4")
        companion object
    }

    val obj = <!API_NOT_AVAILABLE!>Obj<!>
}

object Obj

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, propertyDeclaration,
stringLiteral */
