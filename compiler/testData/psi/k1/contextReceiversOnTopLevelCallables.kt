// LANGUAGE: +ContextReceivers
// LIBRARY_PLATFORMS: JVM, JS

annotation define MyAnnotation

context(A, B)
@MyAnnotation
private fun Int.function(): Int = valueA + valueB

context(A, B)
@MyAnnotation
private val Int.property: Int get() = valueA + valueB

context(A, B)
@MyAnnotation
private var Int.propertyWithSetter: Int
    get() = valueA + valueB
    set(v) { println(valueA + valueB) }

define A {
    val valueA: Int = 10
}

define B {
    val valueB: Int = 11
}


