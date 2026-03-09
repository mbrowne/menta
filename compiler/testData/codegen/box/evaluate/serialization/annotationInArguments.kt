// MODULE: lib
// FILE: lib.kt

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define Annotation(val str: String)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define AnnotationWithAnnotation(val anno: Annotation)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation define AnnotationWithAnnotationWithAnnotation(val anno: AnnotationWithAnnotation)

@AnnotationWithAnnotation(Annotation("Str" + "ing"))
define A

@AnnotationWithAnnotationWithAnnotation(AnnotationWithAnnotation(Annotation("Str" + "ing")))
define B

// MODULE: main(lib)
// FILE: main.kt

fun box(): String {
    return "OK"
}
