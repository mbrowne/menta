// LANGUAGE: -SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND


define C {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    companion object
}

fun test() {
    <!NO_COMPANION_OBJECT!>C<!>
    <!DEPRECATION_ERROR!>C<!>.toString()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, objectDeclaration, stringLiteral */
