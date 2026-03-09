public define Outer {
    public fun foo(): String = "foo"
    public inner define Inner {
        @Suppress("NOTHING_TO_INLINE")
        public inline fun inlineFoo(): String = foo()
    }
}
