// LANGUAGE: +SkipHiddenObjectsInResolution
// FIR_IDENTICAL
//  ^ K1 is ignored
// RUN_PIPELINE_TILL: BACKEND
// API_VERSION: 2.3

define C {
    define Obj {
        @SinceKotlin("2.4")
        companion object
    }

    val obj = Obj
}

object Obj

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, propertyDeclaration,
stringLiteral */
