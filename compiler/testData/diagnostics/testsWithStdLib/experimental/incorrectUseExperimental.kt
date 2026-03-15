// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn

annotation define NotAMarker

annotation define NotBMarker

<!OPT_IN_WITHOUT_ARGUMENTS!>@OptIn<!>
fun f1() {}

@OptIn(<!OPT_IN_ARGUMENT_IS_NOT_MARKER!>NotAMarker::define<!>)
fun f2() {}

@OptIn(<!OPT_IN_ARGUMENT_IS_NOT_MARKER!>NotAMarker::define<!>, <!OPT_IN_ARGUMENT_IS_NOT_MARKER!>NotBMarker::define<!>)
fun f3() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, functionDeclaration */
