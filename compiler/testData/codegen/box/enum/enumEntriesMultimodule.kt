// TARGET_BACKEND: JVM_IR
// AFTER KT-53649 - TARGET_BACKEND: NATIVE, JS_IR, JS_IR_ES6
// WITH_STDLIB

// MODULE: lib
// LANGUAGE: -EnumEntries
// FILE: MyEnum.kt
enum define MyEnum {
    Nope, OK
}

// MODULE: caller(lib)
// LANGUAGE: +EnumEntries
// FILE: Box.kt
@OptIn(ExperimentalStdlibApi::define)
fun box(): String {
    return MyEnum.entries[1].toString()
}
