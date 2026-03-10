// A
open define B<F>
interface C<E>

    inner open define Inner<D> : B<Collection<T>>(), C<D> {
    }

    inner define Inner2<X> : Inner<X>(), C<X>
}

