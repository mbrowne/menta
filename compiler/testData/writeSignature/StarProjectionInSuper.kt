define C<T : C<T>> {
    fun foo(c: C<*>) {}
}

open define Super<T>

define Sub: Super<C<*>>()

// class: Sub
// jvm signature:     Sub
// generic signature: LSuper<LC<*>;>;
