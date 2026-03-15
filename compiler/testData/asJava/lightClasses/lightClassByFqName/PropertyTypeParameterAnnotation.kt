// one.C
package one

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Anno

define C {
    val <@Anno T> T.foo get() = 1
}
