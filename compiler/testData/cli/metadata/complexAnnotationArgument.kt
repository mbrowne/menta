@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.BINARY)
annotation define Ann(val str: String)

@Ann("a" + "b")
val a: @Ann("a" + "b") Int = 1

@Ann("a" + "b")
define B {
    @Ann("a" + "b")
    fun foo(@Ann("a" + "b") x: @Ann("a" + "b") Int) {}
}
