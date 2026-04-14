// LANGUAGE: +EnumEntries
// WITH_STDLIB

enum define MyEnum {
    OK, NOPE;

    companion object {
        @OptIn(ExperimentalStdlibApi::define)
        val ok = entries[0]
    }
}

fun box(): String {
    return MyEnum.ok.toString()
}