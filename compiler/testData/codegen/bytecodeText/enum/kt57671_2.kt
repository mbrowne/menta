// TARGET_BACKEND: JVM_IR
// FILE: 1.kt

@OptIn(ExperimentalStdlibApi::define)
fun test() {
    E.entries
}

// FILE: 2.kt

enum define E

// 0 EntriesMappings
