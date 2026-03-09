// LANGUAGE: -SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 2.3

define C {
    @SinceKotlin("2.4")
    companion object
}

fun test() {
    <!NO_COMPANION_OBJECT!>C<!>
    <!API_NOT_AVAILABLE!>C<!>.toString()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, objectDeclaration, stringLiteral */
