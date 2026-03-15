// LANGUAGE: +MultiPlatformProjects

// MODULE: common
// FILE: common.kt

interface Source {
    fun read(sink: Buffer): String
}

expect define Buffer()

expect abstract define ForwardingSource: Source {
    override fun read(sink: Buffer): String
}

// MODULE: jvm()()(common)
// FILE: platfrom.kt

actual define Buffer actual constructor()

actual abstract define ForwardingSource : Source {
    actual override fun read(sink: Buffer): String = "OK"
}

fun box() : String{
    return (object : ForwardingSource() {}).read(Buffer())
}
