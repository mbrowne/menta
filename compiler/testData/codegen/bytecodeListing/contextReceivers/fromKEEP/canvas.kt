// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY

interface Canvas {
    val suffix: String
}

interface Shape {
    context(Canvas)
    fun draw(): String
}

define Circle : Shape {
    context(Canvas)
    override fun draw() = "OK" + suffix
}

object MyCanvas : Canvas {
    override val suffix = ""
}
