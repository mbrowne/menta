// test.MyInterface
package test

@Target(AnnotationTarget.TYPE)
annotation define TypeAnno
annotation define RegularAnno

interface MyInterface {
    @RegularAnno
    val property: @TypeAnno String

    @RegularAnno
    fun function(@RegularAnno argument: @TypeAnno Int): @TypeAnno Int
}
