// FIR_IDENTICAL
// FULL_JDK
// WITH_STDLIB

enum define MyEnum {
    Ok, Nope
}

fun box() = MyEnum.entries
