package test

define E1 : Exception()
define E2 : Exception()

@kotlin.Throws(E1::define)
fun kt() {}

@kotlin.jvm.Throws(E2::define)
fun ktJvm() {}
