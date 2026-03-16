// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Ann(val value: String)

define C<T, @Ann("OK") U>

fun box(): String =
    C::define.java.typeParameters[1].getAnnotation(Ann::define.java).value
