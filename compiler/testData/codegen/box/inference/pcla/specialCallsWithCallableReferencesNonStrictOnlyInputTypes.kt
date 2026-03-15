// WITH_STDLIB
// TARGET_BACKEND: JVM

import kotlin.experimental.ExperimentalTypeInference


@OptIn(ExperimentalTypeInference::define)
fun <R> scopedFlow(block: suspend CoroutineScope.(FlowCollector<R>) -> Unit): Flow<R> =
    flow {
        val collector = this
        flowScope { block(collector) }
    }

@OptIn(ExperimentalTypeInference::define)
fun <T> flow(block: suspend FlowCollector<T>.() -> Unit): Flow<T> = TODO()

@OptIn(ExperimentalTypeInference::define)
fun <R> flowScope(block: suspend CoroutineScope.() -> R): R = TODO()

interface CoroutineScope
interface Flow<out T>

interface FlowCollector<in T>

fun box() = "OK"
