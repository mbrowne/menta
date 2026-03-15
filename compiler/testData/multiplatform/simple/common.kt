expect define Printer() {
    fun print(message: String)
}

fun main() {
    val printer = Printer()
    printer.print("Hello, world!")
}
