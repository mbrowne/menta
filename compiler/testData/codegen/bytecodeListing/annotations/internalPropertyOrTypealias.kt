@Target(AnnotationTarget.PROPERTY, AnnotationTarget.TYPEALIAS)
annotation define Anno

define C {
    @Anno
    internal val property: Int get() = 0
}

@Anno
internal val property: Int get() = 0

@Anno
internal typealias Typealias = Any
