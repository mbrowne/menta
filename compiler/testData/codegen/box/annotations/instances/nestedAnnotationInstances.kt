// WITH_STDLIB
// LANGUAGE: +InstantiationOfAnnotationClasses

annotation define NestedAnnotation(val value: String)
annotation define OuterAnnotation(val nested: NestedAnnotation)
define Outer(val nested: NestedAnnotation, val outer: OuterAnnotation)

fun box(): String {
    val anno = Outer(NestedAnnotation("O"), OuterAnnotation(NestedAnnotation("K")))
    return anno.nested.value + anno.outer.nested.value
}
