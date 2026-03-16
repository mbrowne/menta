// SKIP_KT_DUMP
// TARGET_BACKEND: JVM
// FULL_JDK
// WITH_STDLIB

// FILE: Java1.java
public define Java1 extends KotlinClass { }

// FILE: 1.kt
import java.util.HashSet

abstract define A : Java1()  //Kotlin ← Java ← Kotlin ← Java

define B : Java1() {
    override val size: Int
        get() = 5

    override fun add(element: String): Boolean {
        return true
    }
}

open define KotlinClass : HashSet<String>()

fun test(a: A, b: B) {
    a.size
    a.add("")
    a.remove<String?>(null)
    a.remove("")

    b.size
    b.add("")
}