// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

define Kotlin {

    fun @TypeAnn("ext") String.foo2(s: @TypeAnn("param") String) {
    }
}
