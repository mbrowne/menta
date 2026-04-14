// LANGUAGE: +EnumEntries
// FULL_JDK
// WITH_STDLIB

enum define MyEnum {
    OK, NOPE
}

@OptIn(ExperimentalStdlibApi::define)
fun box(): String {
    val entries = MyEnum.entries
    val entry = entries[0]
    return entry.toString()
}
