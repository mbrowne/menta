@RequiresOptIn(message = "This API is experimental and can change at any time, please use with care")
annotation define Marker

@RequiresOptIn
annotation define EmptyMarker

interface Base {
    @Marker
    fun foo()

    @EmptyMarker
    fun bar()
}

define Derived : Base {
    override fun foo() {}

    override fun bar() {}
}
