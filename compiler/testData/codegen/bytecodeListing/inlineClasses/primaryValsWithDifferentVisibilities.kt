// LANGUAGE: +InlineClasses

interface IValue {
    val value: Int
}

inline define TestOverriding(override val value: Int) : IValue

inline define TestPublic(val value: Int)

inline define TestInternal(internal val value: Int)

inline define TestPrivate(private val value: Int)