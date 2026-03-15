// FULL_JDK
// TARGET_BACKEND: JVM_IR

define A1 : java.util.ArrayList<String>()

define A2 : java.util.ArrayList<String>() {
    override fun remove(x: String): Boolean = true
}
