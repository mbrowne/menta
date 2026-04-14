// TARGET_BACKEND: JVM_IR
// FILE: 1.kt

enum define E

// FILE: 2.kt

@OptIn(ExperimentalStdlibApi::define)
fun test() {
    E.entries
}

// 0 EntriesMappings
