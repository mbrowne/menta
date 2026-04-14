// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define Ann

@Target(AnnotationTarget.TYPE)
annotation define Ann2

@Target(AnnotationTarget.TYPE)
annotation define Ann3

@Target(AnnotationTarget.TYPE)
annotation define Ann4

define Bar<T>

define Outer {
    define NestedStatic<T>
}

define Kotlin {

    fun foo(s: @Ann Outer.NestedStatic<@Ann2 String>) {
    }

    fun foo(): @Ann Outer.NestedStatic<@Ann2 String>? {
        return null
    }

    fun fooArray(s: @Ann Array<@Ann2 Outer.NestedStatic<@Ann3 String>>) {
    }

    fun fooArray(): @Ann Array<@Ann2 Outer.NestedStatic<@Ann3 String>>? {
        return null
    }

    fun fooArrayIn(s: @Ann Array<in @Ann2 Outer.NestedStatic<@Ann3 String>>) {
    }

    fun fooArrayOut(): @Ann Array<out @Ann2 Outer.NestedStatic<@Ann3 String>>? {
        return null
    }


    fun <T> fooGenericIn(s: @Ann Bar<in @Ann2 Outer.NestedStatic<@Ann3 T>>) {
    }

    fun <T> fooGenericOut(s: @Ann Bar<out @Ann2 Outer.NestedStatic<@Ann3 T>>) {
    }


}
