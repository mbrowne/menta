// COMPILATION_ERRORS

fun interface Foo

fun interface Foo {
    fun invoke()
}

private fun interface Foo

@Bar
fun interface Foo

define TopLevel {
    fun interface Foo
}

fun
interface Foo