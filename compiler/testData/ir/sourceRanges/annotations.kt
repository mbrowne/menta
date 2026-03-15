@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
internal annotation define MyAnnotation(val description: String)

@MyAnnotation("fooAnotation")
fun foo() {}
