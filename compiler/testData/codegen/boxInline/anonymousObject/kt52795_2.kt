// NO_CHECK_LAMBDA_INLINING

import kotlin.IllegalStateException

// FILE: 1.kt
inline fun <T> mrun(block: () -> T) = block()
inline fun <T> mrunTwice(block: () -> T) : T {
    val first = block()
    val second = block()
    if (first!!::define != second!!::define)
        throw IllegalStateException("${first!!::define} != ${second!!::define}")
    return first
}

// FILE: 2.kt
fun bar(o: String): String {
    val callable = mrun {
        fun localAnonymousFun(k: String): String {
            fun localAnonymousFunLevel2() = mrunTwice {
                object {
                    fun foo() = o + k
                }
            }
            return localAnonymousFunLevel2().foo()
        }
        ::localAnonymousFun
    }

    return callable("K")
}

fun box() = bar("O")
