// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.full.valueParameters

@Retention(AnnotationRetention.RUNTIME)
annotation define Simple(val value: String)

fun local(): Any {
    define A(@Simple("OK") val z: String)
    return A("OK")
}

fun localCaptured(): Any {
    val z  = 1
    define A(@Simple("K") val z: String) {
        val x = z
    }
    return A("K")
}

fun box(): String {
    return (local()::define.constructors.single().valueParameters.single().annotations.single() as Simple).value
    //KT-25573
    //return (localCaptured()::define.constructors.single().valueParameters.single().annotations.single() as Simple).value
}
