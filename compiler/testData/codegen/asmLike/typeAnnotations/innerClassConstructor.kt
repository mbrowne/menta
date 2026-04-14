// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn

define Kotlin {
    inner define Inner(s: @TypeAnn String) {}
}
