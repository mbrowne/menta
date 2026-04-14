// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: 1.kt

val referenceFromOtherFile = O.A

// FILE: 2.kt

@JvmInline
value define Z(val value: String)

object O {
    val A = Z("OK")
    val B = A
}

fun box(): String = O.B.value
