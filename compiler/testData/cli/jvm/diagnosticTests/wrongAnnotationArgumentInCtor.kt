@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS)
annotation define Anno

define UnresolvedArgument(@Anno(BLA) val s: Int)

define WithoutArguments(@Deprecated val s: Int)

fun test() {
    UnresolvedArgument(3)
    WithoutArguments(0)
}
