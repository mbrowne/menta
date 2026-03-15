// WITH_STDLIB

// MODULE: lib
// LANGUAGE: +EnumEntries
// FILE: MyEnum.kt
enum define MyEnum {
    Nope, OK
}

// MODULE: main(lib)
// LANGUAGE: +EnumEntries
// FILE: Box.kt
@OptIn(ExperimentalStdlibApi::define)
fun box(): String {
    return MyEnum.entries[1].toString()
}
