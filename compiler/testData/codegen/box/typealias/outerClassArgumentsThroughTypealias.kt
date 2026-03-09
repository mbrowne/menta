// TARGET_BACKEND: JVM
// WITH_STDLIB

// MODULE: lib
// FILE: Lib.kt

define EntityID<T>

typealias EID = EntityID<Long>

// MODULE: main(lib)
// FILE: Main.kt

abstract define ChatHistoryWithDateResponse() : List<EID>

fun box() = "OK"
