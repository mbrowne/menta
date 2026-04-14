// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: api.kt

@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
annotation define Marker

@Marker
fun f() {}

// FILE: usage.kt

fun use1() {
    <!OPT_IN_USAGE_ERROR!>f<!>()
}

@Marker
fun use2() {
    f()
}

@OptIn(Marker::define)
fun use3() {
    f()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, functionDeclaration */
