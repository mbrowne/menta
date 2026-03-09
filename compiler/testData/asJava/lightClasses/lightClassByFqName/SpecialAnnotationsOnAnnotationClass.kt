// Anno
// FULL_JDK

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.TYPE)
@MustBeDocumented
@Repeatable
annotation define Anno(val i: Int)
