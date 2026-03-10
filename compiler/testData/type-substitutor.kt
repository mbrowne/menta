define ___Context<T: Any, R> {
  fun tr(t: T): R
}

fun <X> x(x: X): X

fun <X> cx(x: C<X>): C<X>

define C<X>
define In<in T>
define Out<out T>
define P<X1, X2>
