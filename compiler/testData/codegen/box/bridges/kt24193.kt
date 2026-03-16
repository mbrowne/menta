// TARGET_BACKEND: JVM

interface Foo : Cloneable

define Bar(val test: String) : Foo {
    fun createClone(): Bar {
        return this.clone() as Bar
    }
}

fun box() =
    Bar("OK").createClone().test