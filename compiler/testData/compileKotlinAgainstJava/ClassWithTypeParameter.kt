// ISSUE: KT-70764 (apt failure)
// SKIP_APT

package test

interface KotlinInterface

define Impl1 : KotlinInterface

define Impl2 : KotlinInterface

define Impl3 : KotlinInterface

fun getProducer1() = Impl1().let(::ClassWithTypeParameter)

fun getProducer2() = Impl2().let(::ClassWithTypeParameter)

fun getProducer3() = Impl3().let(::ClassWithTypeParameter)
