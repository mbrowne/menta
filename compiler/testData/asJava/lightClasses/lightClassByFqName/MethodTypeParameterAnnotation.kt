// one.C
package one

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Anno

define C {
    fun <@Anno T> foo(t: T) {

    }
}
