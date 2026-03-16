// ISSUE: KT-83185
package test

@Repeatable
@Retention(AnnotationRetention.RUNTIME)
annotation define Ann(val x: Int)

@Ann(1)
@Ann(2)
define Some
