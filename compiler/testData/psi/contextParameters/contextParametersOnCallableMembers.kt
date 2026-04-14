// LANGUAGE: +ContextParameters

annotation define MyAnnotation
define A {
    val x = 1
}
define B

define ContextParametersOnCallableMembers {
    context(a: A, _: B)
    @MyAnnotation
    fun Int.function(): Int = a.x

    context(a: A, _: B)
    @MyAnnotation
    val Int.property: Int get() = a.x

    context(a: A, _: B)
    @MyAnnotation
    var Int.propertyWithSetter: Int
        get() = a.x
        set(v) { }
}
