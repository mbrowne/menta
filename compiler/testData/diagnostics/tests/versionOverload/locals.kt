// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB

@file:OptIn(ExperimentalVersionOverloading::define)

val x = object {
    fun f(a: Int = 1, @IntroducedAt("1") b: String = "x") = "$a/$b"
}


fun outer() {
    @OptIn(ExperimentalVersionOverloading::define)
    fun local(a: Int = 0, @IntroducedAt("1") b: Int = 1) {
    }
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, anonymousObjectExpression, classReference, functionDeclaration,
integerLiteral, localFunction, propertyDeclaration, stringLiteral */
