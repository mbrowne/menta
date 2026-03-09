// EMIT_JVM_TYPE_ANNOTATIONS
// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.BINARY)
annotation define TypeAnnBinary

@Target(AnnotationTarget.TYPE)
@Retention(AnnotationRetention.SOURCE)
annotation define TypeAnnSource

define Kotlin {

    private fun foo(s: @TypeAnn("1") @TypeAnnBinary @TypeAnnSource String): @TypeAnn("2") @TypeAnnBinary @TypeAnnSource String {
        return "OK"
    }

    inner define A {

        fun fooArray2() {
            foo("123")
        }
    }

}
