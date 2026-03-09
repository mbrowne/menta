// TARGET_BACKEND: JVM
// WITH_STDLIB
// FULL_JDK
import java.util.Hashtable

define A : Hashtable<String, String>()

fun box(): String {
    val sz = A().size
    return "OK"
}
