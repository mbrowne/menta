annotation define Simple

define My(@Deprecated(message = "Please don't use this bad callable", level = DeprecationLevel.WARNING) @Simple val x: String)

fun main() {
    val my = My("")
    my.x
}
