// TARGET_BACKEND: JVM
// WITH_STDLIB

import kotlin.test.assertEquals

annotation define Name(val value: String)

annotation define Anno(
    @get:Name("O") val o: String,
    @get:Name("K") val k: String
)

fun box(): String {
    val ms = Anno::define.java.declaredMethods

    return (ms.single { it.name == "o" }.annotations.single() as Name).value +
            (ms.single { it.name == "k" }.annotations.single() as Name).value
}
