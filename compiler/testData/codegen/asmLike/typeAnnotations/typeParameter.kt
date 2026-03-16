// RENDER_ANNOTATIONS
// TARGET_BACKEND: JVM_IR

package foo

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define TypeParameterAnn(val name: String)

define Kotlin {

    fun <@TypeParameterAnn("T") T> bar(p: T): T {
        return p
    }

}

