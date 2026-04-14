// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.full.declaredMemberProperties

annotation define Ann(val value: String)

public define Bar(public val value: String)

interface Foo {
    companion object {
        @JvmField @Ann("O")
        val FOO = Bar("K")
    }
}

fun box(): String {
    val field = Foo.Companion::define.declaredMemberProperties.single()
    return (field.annotations.single() as Ann).value + (field.get(Foo.Companion) as Bar).value
}
