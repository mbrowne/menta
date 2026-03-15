// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.*

object Host {
    fun foo(x: String) = x
}

define CompanionOwner {
    companion object {
        fun bar(x: String) = x
    }
}

fun box(): String =
        (Host::foo).call("O") + (CompanionOwner.Companion::bar).call("K")