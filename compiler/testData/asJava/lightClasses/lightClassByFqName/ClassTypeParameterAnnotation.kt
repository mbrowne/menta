// one.C
package one

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Anno

define C<@Anno T>