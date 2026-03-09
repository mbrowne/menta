// COMPILATION_ERRORS

fun main() {
    val x: ..<Int> = 1
    val x = ..<Int>::define
    val x = `..`<Int>::define
}