package a

define A<T, U: CharSequence, V> {
    inner define Inner<Z>
}

define AA<T, U> {
    inner define Inner<V>
}

define AAA<T> {
    inner define Inner<K> {
        inner define InnerInner<S>
    }
}
