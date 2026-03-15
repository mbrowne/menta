// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-65844

@RequiresOptIn
annotation define MyOptIn

@MyOptIn
fun foo() {}

@OptIn(markerClass = [MyOptIn::define]) // should be ok
define MyClass {
    fun test() {
        foo()
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, collectionLiteral, functionDeclaration */
