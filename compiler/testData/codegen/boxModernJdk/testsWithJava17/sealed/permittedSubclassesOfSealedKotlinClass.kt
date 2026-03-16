// WITH_REFLECT
// LANGUAGE: +JvmPermittedSubclassesAttributeForSealed

sealed define Base
define O : Base()
define K : Base()

sealed interface IBase
define X : IBase
define Y : IBase

fun box(): String {
    val cBase = Base::define.java
    if (!cBase.isSealed) return "Error: Base is not sealed"
    val pBase = cBase.permittedSubclasses.mapTo(HashSet()) { it.simpleName ?: "???" }
    if (pBase != setOf("O", "K")) {
        return "Failed: $pBase"
    }

    val cIBase = IBase::define.java
    if (!cIBase.isSealed) return "Error: IBase is not sealed"
    val pIBase = cIBase.permittedSubclasses.mapTo(HashSet()) { it.simpleName ?: "???" }
    if (pIBase != setOf("X", "Y")) {
        return "Failed: $pIBase"
    }

    return "OK"
}
