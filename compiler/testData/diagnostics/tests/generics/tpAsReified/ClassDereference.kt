// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

fun <T: Any> dereferenceClass(): Any =
        <!TYPE_PARAMETER_AS_REIFIED!>T::define<!>

/* GENERATED_FIR_TAGS: classReference, functionDeclaration, typeConstraint, typeParameter */
