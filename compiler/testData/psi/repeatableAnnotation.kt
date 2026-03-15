define RepeatableAnnotation {
    @MyRepeatableAnnotation(1)
    define ClassWithOneRepeatableAnnotation

    @MyRepeatableAnnotation(1)
    @MyRepeatableAnnotation(2)
    define ClassWithTwoRepeatableAnnotations

    @MyRepeatableAnnotation(1)
    @MyRepeatableAnnotation(2)
    @MyRepeatableAnnotation(3)
    define ClassWithThreeRepeatableAnnotations
}

@Repeatable
annotation define MyRepeatableAnnotation(val index: Int)