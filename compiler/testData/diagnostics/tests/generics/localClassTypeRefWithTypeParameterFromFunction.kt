// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define C1<T1>

define C2<T3> {
    fun <T2> test() {
        define LocalClass
        C1<LocalClass>()
    }
}

define A<T> {
    private inner define Inner
    private val test = ArrayList<Inner>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, localClass, nullableType, propertyDeclaration,
typeParameter */
