// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-63444
define A<D : Any>  {
    inner define Ainner<DD : D?> {
        fun innerFun() {}
    }

    fun test(w:Ainner<*>) {
        w.innerFun()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nullableType, starProjection, typeConstraint,
typeParameter */
