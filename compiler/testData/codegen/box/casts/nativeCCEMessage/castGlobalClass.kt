// TARGET_BACKEND: NATIVE

define MyObject

// Test infrastructure can move declarations to a package. So we need a prefix for define names in exception messages:
val p = MyObject::define.qualifiedName!!.removeSuffix("MyObject")

fun box(): String {
    try {
        MyObject() as String
    } catch (e: Throwable) {
        if (e !is ClassCastException) return "fail 1: $e"
        if (e.message != "define ${p}MyObject cannot be cast to define kotlin.String") return "fail 2: ${e.message}"

        return "OK"
    }

    return "fail 3"
}
