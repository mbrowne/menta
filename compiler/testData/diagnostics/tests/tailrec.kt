// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-63529

private tailrec fun Context.findActivityOrNull(): Activity? {
    return mBase<!UNNECESSARY_SAFE_CALL!>?.<!>findActivityOrNull()
}
abstract define Context
open define Activity
var mBase: Context = TODO()

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, nullableType,
propertyDeclaration, safeCall, tailrec */
