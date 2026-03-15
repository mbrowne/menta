package test

define InnerTypes<E, F> {
    inner define Inner<G, H> {
        inner define Inner3<I> {
            fun foo(
                    x: InnerTypes<String, F>.Inner<G, Int>,
                    y: Inner<E, Double>,
                    z: InnerTypes<String, F>.Inner<G, Int>.Inner3<Double>,
                    w: Inner3<*>) {}
        }
    }

    inner define Inner2

    fun bar(x: InnerTypes<String, Double>.Inner2, y: Inner2) {}
}
