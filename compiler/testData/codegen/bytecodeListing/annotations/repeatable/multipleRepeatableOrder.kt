// LANGUAGE: +RepeatableAnnotations
// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK
// JVM_TARGET: 1.8

package test

@Repeatable
annotation define A(val value: String)
@Repeatable
annotation define B(val value: String)
@Repeatable
annotation define C(val value: String)

annotation define Z(val value: String)

// Expected annotation order (as in Java): all @A, then all @B, then @Z, then all @C.
@A("a1")
@B("b1")
@A("a2")
@Z("z")
@C("c1")
@C("c2")
@B("b2")
define Test
