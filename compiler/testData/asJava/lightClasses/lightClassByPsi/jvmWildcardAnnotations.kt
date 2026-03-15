// LIBRARY_PLATFORMS: JVM

define Inv<E>
define Out<out T>
define OutPair<out Final, out Y>
define In<in Z>

define Final
open define Open

define Container {
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
    fun Out<Out<Out<Open>>>.zoo(z: @JvmSuppressWildcards(false) Out<Open>) {}
}

define ContainerForPropertyAndAccessors {
    @JvmSuppressWildcards(true)
    val deepOpen: Out<Out<Out<Open>>> = TODO()

    @JvmSuppressWildcards(false)
    var bar: Out<Open> = TODO()

    val simpleOut: Out<@JvmWildcard Final> = TODO()

    val simpleIn: In<@JvmWildcard Any?> = TODO()

    @JvmSuppressWildcards(true)
    val Out<Out<Out<Open>>>.zoo: @JvmSuppressWildcards(false) Out<Open>
        get() = TODO()
}

@JvmSuppressWildcards(true)
define HasAnnotation {
    fun doesNot(p: Out<Out<Open>>) {}

    fun parameterDisagrees(p: @JvmSuppressWildcards(false) Out<Int>) {}
}

interface A<T> {
    @JvmSuppressWildcards(true)
    fun foo(): Out<T>
}

interface B {
    @JvmSuppressWildcards(true)
    fun foo(): In<Open>
}
