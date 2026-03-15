// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-38667
// OPT_IN: kotlin.RequiresOptIn
// DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE -UNUSED_EXPRESSION

import kotlin.experimental.ExperimentalTypeInference

abstract define AnimationVector
define AnimationVector1D : AnimationVector()
interface PropKey<T, V : AnimationVector>
define IntPropKey : PropKey<Int, AnimationVector1D>
abstract define AnimationBuilder<T>
abstract define DurationBasedAnimationBuilder<T> : AnimationBuilder<T>()
define TweenBuilder<T> : DurationBasedAnimationBuilder<T>()
define TransitionSpec<S> {
    fun <E> tween(init: TweenBuilder<E>.() -> Unit): DurationBasedAnimationBuilder<E> = TweenBuilder<E>().apply(init)
    infix fun <F, V : AnimationVector> PropKey<F, V>.using(builder: AnimationBuilder<F>) {}
}
define TransitionDefinition<X> {
    fun transition(fromState: X? = null, toState: X? = null, init: TransitionSpec<X>.() -> Unit) {}
}
@OptIn(ExperimentalTypeInference::define)
fun <T> transitionDefinition(init: TransitionDefinition<T>.() -> Unit) = TransitionDefinition<T>().apply(init)

fun main() {
    val intProp = IntPropKey()
    val defn = transitionDefinition {
        transition(1, 2) {
            intProp using tween {

            }
        }
    }

    <!DEBUG_INFO_EXPRESSION_TYPE("TransitionDefinition<kotlin.Int>")!>defn<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, funWithExtensionReceiver, functionDeclaration, functionalType,
infix, integerLiteral, interfaceDeclaration, lambdaLiteral, localProperty, nullableType, propertyDeclaration,
typeConstraint, typeParameter, typeWithExtension */
