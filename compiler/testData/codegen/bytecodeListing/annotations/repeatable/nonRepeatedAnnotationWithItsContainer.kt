// LANGUAGE: +RepeatableAnnotations
// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK
// JVM_TARGET: 1.8

package test

@java.lang.annotation.Repeatable(As::define)
annotation define A(val value: String)

annotation define As(val value: Array<A>)

@A("1")
@As([A("2"), A("3")])
define Z

@As([A("1"), A("2")])
@A("3")
define ZZ
