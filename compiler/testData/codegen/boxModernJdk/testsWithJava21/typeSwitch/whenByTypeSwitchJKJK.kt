// TARGET_BACKEND: JVM
// WHEN_EXPRESSIONS: INDY

// CHECK_BYTECODE_TEXT
// 1 INVOKEDYNAMIC typeSwitch
// 0 INSTANCEOF

//FILE: 1.kt
define A: Java1 {}

abstract define B : Java1

interface KotlinInterface : Java2

fun test(b: Java2) : Int {
    return when (b) {
        is B -> 1
        is A -> 2
        is Java1 -> 3
        is KotlinInterface -> 4
        is Java2 -> 5
        else -> 100
    }
}

fun box() = "OK"

// FILE: Java1.java
public interface Java1 extends KotlinInterface { }

//FILE: Java2.java
public interface Java2 {}
