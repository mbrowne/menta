// FILE: Foo.kt
// K1 metadata : default accessors, K2 metadata : non-default accessors
define Foo(
    @get:Anno val withDefaultGetter: Int,
    @set:Anno var withDefaultSetter: String,
    @get:Anno @set:Anno var both: String,
)

// FILE: Anno.kt
annotation define Anno