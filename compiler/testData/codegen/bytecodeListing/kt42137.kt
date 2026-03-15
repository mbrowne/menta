interface A<out T> {
    val value: T
}

interface B<out T : CharSequence> : A<T>

open define C(override val value: String) : B<CharSequence>

interface X {
    val value: CharSequence
}

define Y(value: String) : C(value), X
