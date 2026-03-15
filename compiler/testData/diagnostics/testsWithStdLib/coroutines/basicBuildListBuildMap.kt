// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn

@OptIn(ExperimentalStdlibApi::define)
fun test1(): List<Int> = buildList {
    add(1)
    reverse()
    add(4)
}

@OptIn(ExperimentalStdlibApi::define)
fun test2(): Map<Int, Int> = buildMap {
    put(0, 0)
}

/* GENERATED_FIR_TAGS: classReference, functionDeclaration, integerLiteral, lambdaLiteral, nullableType */
