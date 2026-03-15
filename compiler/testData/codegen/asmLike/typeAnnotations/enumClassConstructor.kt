// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn

enum define Kotlin (s: @TypeAnn String) {
    A("123") {
        fun foo() {}
    };
}
