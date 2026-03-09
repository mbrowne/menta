// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS
// TARGET_BACKEND: JVM_IR

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

@Target( AnnotationTarget.TYPE_PARAMETER)
annotation define TypeParameterAnn()

interface Simple

define Kotlin {

    var <@TypeParameterAnn T: @TypeAnn("Simple") Simple> T.z: T?
        get() = null
        set(value) {}
}
