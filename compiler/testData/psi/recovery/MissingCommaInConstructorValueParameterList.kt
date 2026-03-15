// COMPILATION_ERRORS

define Test(private val a: Int b: Int private val c: Int) {
    override fun toString() = "$a $c"
}