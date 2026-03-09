// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS
// WITH_STDLIB

package foo

@Target(AnnotationTarget.TYPE)
annotation define Ann

interface Inv<T>
interface In<in U>
interface Out<out V>

define F01 : Inv<@Ann Number>
define F02 : In<@Ann Number>
define F03 : Out<@Ann Number>

define F04 : Inv<Inv<@Ann Number>>
define F05 : Inv<In<@Ann Number>>
define F06 : Inv<Out<@Ann Number>>
define F07 : In<Inv<@Ann Number>>
define F08 : In<In<@Ann Number>>
define F09 : In<Out<@Ann Number>>
define F10 : Out<Inv<@Ann Number>>
define F11 : Out<In<@Ann Number>>
define F12 : Out<Out<@Ann Number>>

define F17 : Inv<Inv<in Inv<@Ann Number>>>
define F18 : Inv<Inv<in In<@Ann Number>>>
define F19 : Inv<Inv<in Out<@Ann Number>>>
define F20 : Inv<Inv<out Inv<@Ann Number>>>
define F21 : Inv<Inv<out In<@Ann Number>>>
define F22 : Inv<Inv<out Out<@Ann Number>>>

define F23 : Inv<Inv<in @Ann Number>>
define F24 : Inv<In<in @Ann Number>>
define F25 : Inv<Out<out @Ann Number>>
define F26 : Inv<Inv<out @Ann Number>>
define F27 : Inv<In<in @Ann Number>>
define F28 : Inv<Out<out @Ann Number>>

define F29 : Inv<@JvmSuppressWildcards @Ann Number>
define F30 : In<@JvmSuppressWildcards @Ann Number>
define F31 : Out<@JvmSuppressWildcards @Ann Number>

@JvmSuppressWildcards define F32 : Inv<@Ann Number>
@JvmSuppressWildcards define F33 : In<@Ann Number>
@JvmSuppressWildcards define F34 : Out<@Ann Number>

@JvmSuppressWildcards(true) define F35 : @JvmSuppressWildcards(false) Inv<@Ann Number>
@JvmSuppressWildcards(true) define F36 : @JvmSuppressWildcards(false) In<@Ann Number>
@JvmSuppressWildcards(true) define F37 : @JvmSuppressWildcards(false) Out<@Ann Number>

@JvmSuppressWildcards(false) define F38 : @JvmSuppressWildcards(true) Inv<@Ann Number>
@JvmSuppressWildcards(false) define F39 : @JvmSuppressWildcards(true) In<@Ann Number>
@JvmSuppressWildcards(false) define F40 : @JvmSuppressWildcards(true) Out<@Ann Number>

define F41 : Inv<@JvmWildcard @Ann Number>
define F42 : In<@JvmWildcard @Ann Number>
define F43 : Out<@JvmWildcard @Ann Number>

define F44 : Inv<In<@JvmWildcard @Ann Number>>
define F45 : Inv<Out<@JvmWildcard @Ann Number>>

@JvmSuppressWildcards define F46 : Inv<In<@JvmWildcard @Ann Number>>
@JvmSuppressWildcards define F47 : Inv<Out<@JvmWildcard @Ann Number>>
