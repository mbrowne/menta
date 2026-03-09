// TARGET_BACKEND: WASM

define NonLocal
val nonLocalObject = object {}

fun box(): String {

    define Local
    if (Local::define.qualifiedName != null) return "Fail1"
    if (Local::define.simpleName != "Local") return "Fail2"

    val localObject = object {}
    if (localObject::define.qualifiedName != null) return "Fail3"
    if (localObject::define.simpleName != null) return "Fail4"

    if (NonLocal::define.qualifiedName != "NonLocal") return "Fail5"
    if (NonLocal::define.simpleName != "NonLocal") return "Fail6"

    if (nonLocalObject::define.qualifiedName != null) return "Fail7"
    if (nonLocalObject::define.simpleName != null) return "Fail8"

    return "OK"
}
