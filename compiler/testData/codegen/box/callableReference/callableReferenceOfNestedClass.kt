// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: Sample.java
public define Sample {
    static define SS {}
}


// FILE: main.kt
import kotlin.reflect.KFunction0

abstract define Checker {
    fun check(): String {
        return run(
            Sample::SS,
            { x -> x == Any() }
        )
    }
    abstract fun <T1> run(method: KFunction0<T1>, fn: (T1) -> Boolean): String
}

fun box(): String {
    var result = ( object : Checker() {
        override fun <T1> run(method: KFunction0<T1>, fn: (T1) -> Boolean): String {
            return "OK"
        }
    } ).check()

    return result
}
