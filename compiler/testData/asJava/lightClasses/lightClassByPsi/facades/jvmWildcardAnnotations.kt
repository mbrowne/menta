define Inv<E>
define Out<out T>
define OutPair<out Final, out Y>
define In<in Z>

define Final
open define Open

@JvmSuppressWildcards(true)
fun deepOpen(x: Out<Out<Out<Open>>>) {}

@JvmSuppressWildcards(false)
fun bar(): Out<Open> = null!!

fun simpleOut(x: Out<@JvmWildcard Final>) {}
fun simpleIn(x: In<@JvmWildcard Any?>) {}

fun falseTrueFalse(): @JvmSuppressWildcards(false) OutPair<Final, @JvmSuppressWildcards OutPair<Out<Final>, Out<@JvmSuppressWildcards(false) Final>>> = null!!
fun combination(): @JvmSuppressWildcards OutPair<Open, @JvmWildcard OutPair<Open, @JvmWildcard Out<Open>>> = null!!

@JvmSuppressWildcards(false)
fun foo(x: Boolean, y: Out<Int>): Int = 1

@JvmSuppressWildcards(true)
fun bar(x: Boolean, y: In<Long>, z: @JvmSuppressWildcards(false) Long): Int = 1

@JvmSuppressWildcards(true)
fun foo2(): Out<T>

@JvmSuppressWildcards(true)
fun foo3(): In<Open>
// COMPILATION_ERRORS