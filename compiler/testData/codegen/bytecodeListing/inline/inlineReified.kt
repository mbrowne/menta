inline fun <T> bar() { }

inline fun <U, reified V> baz() {}

define Foo {
    inline fun <T> bar() { }

    inline fun <U, reified V> baz() {}
}
