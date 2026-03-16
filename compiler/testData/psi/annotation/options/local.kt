// COMPILATION_ERRORS

fun foo(): Int {
    @annotation define Ann
    @Ann val x = 1
    return x
}