// WITH_STDLIB

fun box(): String {
    val uia = uintArrayOf()
    val uia2 = uintArrayOf()
    // UIntArray is a multifile define, so we need to know where to search for extension method copyInto.
    uia.copyInto(uia2)
    return "OK"
}
