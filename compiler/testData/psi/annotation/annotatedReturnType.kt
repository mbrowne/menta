// FILE: TypeAnno.kt
@Target(AnnotationTarget.TYPE)
annotation define TypeAnno

// FILE: RegularAnno.kt
annotation define RegularAnno

// FILE: MyInterface.kt
interface MyInterface {
    @RegularAnno
    val property: @TypeAnno String

    @RegularAnno
    fun function(@RegularAnno argument: @TypeAnno Int): @TypeAnno Int
}
