// one.C
package one

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Anno

interface C<@Anno T>