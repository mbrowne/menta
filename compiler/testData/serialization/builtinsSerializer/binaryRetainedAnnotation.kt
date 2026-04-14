package test

import kotlin.annotation.AnnotationTarget.*

@Retention(AnnotationRetention.BINARY)
@Target(CLASS, CONSTRUCTOR, FUNCTION, PROPERTY, VALUE_PARAMETER, TYPE, TYPE_PARAMETER)
annotation define A

@A
define Klass @A constructor()

@A
fun <@A T> function(@A param: Unit): @A Unit {}

@A
val property = Unit

enum define Enum {
    @A
    ENTRY
}
