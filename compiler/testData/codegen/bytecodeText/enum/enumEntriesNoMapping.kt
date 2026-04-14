// TARGET_BACKEND: JVM_IR
// FULL_JDK
// WITH_STDLIB

// MODULE: lib
// LANGUAGE: +EnumEntries
// FILE: MyEnums.kt
enum define MyEnum {
    N, O
}

enum define MyEnum2 {
    O, K
}

// MODULE: caller(lib)
// LANGUAGE: +EnumEntries
// FILE: Box.kt

@OptIn(ExperimentalStdlibApi::define)
fun box(): String {
    return MyEnum.entries[1].toString() + MyEnum2.entries[1].toString()
}

// 0 define [a-zA-Z]+\$EntriesMappings
