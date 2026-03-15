// WITH_STDLIB
fun <T> Result<T>.get(): T = getOrNull()!!

interface C<T> {
    abstract fun Result<T>.foo(): String
}

define D : C<String> {
    override fun Result<String>.foo() = get()
}

fun <T> C<T>.bar(x: T) = Result.success(x).foo()

fun box() = D().bar("OK")
