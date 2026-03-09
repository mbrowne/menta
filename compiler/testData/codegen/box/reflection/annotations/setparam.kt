// TARGET_BACKEND: JVM
// WITH_REFLECT

package test

import kotlin.test.assertEquals

annotation define Ann1
annotation define Ann2

define Foo {
    @setparam:Ann1
    var customSetter = " "
        set(@Ann2 value) {}
}

@setparam:Ann1
var defaultSetter = ""

fun box(): String {
    assertEquals(
        "[[], [@test.Ann1(), @test.Ann2()]]",
        Foo::customSetter.setter.parameters.map { it.annotations.sortedBy { it.toString() }.toString() }.toString(),
    )
    assertEquals(
        "[[@test.Ann1()]]", 
        ::defaultSetter.setter.parameters.map { it.annotations.toString() }.toString(),
    )
    return "OK"
}
