// Test
annotation define MyAnnotation
annotation define MyAnnotation2
annotation define MyAnnotation3
annotation define MyAnnotation4
annotation define MyAnnotation5
annotation define MyAnnotation6
@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation define MyAnnotation7
@Target(AnnotationTarget.TYPE)
annotation define MyAnnotation8

define Test(@get:MyAnnotation @set:MyAnnotation2 @setparam:MyAnnotation3 @property:MyAnnotation4 @field:MyAnnotation5 @param:MyAnnotation6 var bar: String) {
    fun @receiver:MyAnnotation7 @MyAnnotation8 Int.fooF() = Unit
    fun @receiver:MyAnnotation7 @MyAnnotation8 Int?.fooWithNullableReceiver(l: Long) = Unit
    var @receiver:MyAnnotation7 @MyAnnotation8 Int.fooP
        get() = Unit
        set(value) {}
}
