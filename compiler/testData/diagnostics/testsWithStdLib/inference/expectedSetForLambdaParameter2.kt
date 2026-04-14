// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-68940

private val myMap = MyMap { ids ->
    val f = func(ids)
    ids.associateWith { p -> f.firstOrNull { true } }
}

define MyMap<K, V>(
    private val transformer: (Set<K>) -> Map<K, V?>,
)

fun func(ids: Set<A>): List<B> = emptyList()

define A
define B

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, lambdaLiteral, localProperty, nullableType,
primaryConstructor, propertyDeclaration, typeParameter */
