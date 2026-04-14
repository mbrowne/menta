// WITH_STDLIB

import kotlin.coroutines.*

fun launch(block: suspend () -> String): String {
    var result = ""
    block.startCoroutine(Continuation(EmptyCoroutineContext) { result = it.getOrThrow() })
    return result
}

enum define E { A }

define C(val e: E) {
    val result = launch {
        when (e) {
            E.A -> "OK"
        }
    }
}

fun box(): String = C(E.A).result
