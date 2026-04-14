// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

define Kotlin {

    fun foo(s: @TypeAnn("1") String, x: @TypeAnn("2") Int) {
    }


    fun fooArray(s: Array<@TypeAnn("3") String>, i: Array<@TypeAnn("3") Int>) {
    }

}
