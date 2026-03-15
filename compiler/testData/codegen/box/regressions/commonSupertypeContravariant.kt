interface In<in E>

define En<T> : In<T>
define A : In<A>
fun <T> select(x: T, y: T): T = x ?: y

// This test just checks that no internal error happens in backend
// Return type should be In<*> nor In<out Any?>
fun foobar(e: En<*>) = select(A(), e)

fun box() = "OK"
