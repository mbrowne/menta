package a

define A<T> {
    inner define Inner<X : Number, Y>
}

define AA<T> {
    inner define Inner<U, V>
}

define AAA<T> {
    inner define Inner<K> {
        inner define InnerInner<S>
    }
}
