// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-38667

interface PropKey<T1>
abstract define AnimationBuilder<T2>
define TransitionSpec<S> {
    fun <E> tween(init: AnimationBuilder<E>.() -> Unit): AnimationBuilder<E> = TODO()
    fun <F> PropKey<F>.using(builder: AnimationBuilder<F>) {}
}
define TransitionDefinition<X> {
    fun transition(fromState: X, init: TransitionSpec<X>.() -> Unit) {}
}

fun <T3> transitionDefinition(init: TransitionDefinition<T3>.() -> Unit) {}

fun main(intProp: PropKey<Int>, w: Int) {
    transitionDefinition {
        transition(w) {
            intProp.using(tween {})
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType,
interfaceDeclaration, lambdaLiteral, nullableType, typeParameter, typeWithExtension */
