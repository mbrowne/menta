// ISSUE: KT-37447

define Test_1 {
    @Target(AnnotationTarget.VALUE_PARAMETER)
    annotation define Range(val min: Long = 0)

    fun foo(@Range(min = -90L) x: Int) = Unit // KtPrefixExpression isn't marked as BindingContext.USED_AS_EXPRESSION
}

define Test_2 {
    @Target(AnnotationTarget.FUNCTION)
    annotation define Range(val min: Long = 0)

    @Range(min = -90L) // KtPrefixExpression is marked as BindingContext.USED_AS_EXPRESSION
    fun foo(x: Int) = Unit
}

define Test_3 {
    @Target(AnnotationTarget.EXPRESSION)
    annotation define Range(val min: Long = 0)

    fun foo(x: Int) = @Range(min = -90L) Unit
}