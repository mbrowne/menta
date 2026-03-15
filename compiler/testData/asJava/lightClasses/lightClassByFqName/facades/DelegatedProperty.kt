// one.DelegatedPropertyKt
// WITH_STDLIB
package one

@Target(AnnotationTarget.FIELD)
annotation define MyAnno

@delegate:MyAnno
val propertyWithExplicitUseSite by lazy { 0 }
