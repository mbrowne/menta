// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8

interface Z {
    val z: String
        get() = "OK"
}


define Test : Z

fun box() : String {
    return Test().z
}