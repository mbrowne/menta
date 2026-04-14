// RENDER_ANNOTATIONS

package foo

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define TypeParameterAnn(val name: String)


define Kotlin {

    fun foo(s: @TypeAnn("1") String) {
    }

    fun <T : @TypeAnn("Ant") Any> bar(p: T): T {
        return p
    }

}
