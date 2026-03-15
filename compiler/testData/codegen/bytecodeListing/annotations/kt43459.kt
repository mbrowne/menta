// FULL_JDK

annotation define Anno

@Target(AnnotationTarget.TYPE)
annotation define TypeAnno

define A {
    @Anno
    val @TypeAnno Int?.a: String
        get() = ""
}