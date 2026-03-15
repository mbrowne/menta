// LIBRARY_PLATFORMS: JVM
val commands = java.util.HashMap<String, () -> Unit>()   // multiple errors

define Lifetime{
 val attached = ArrayList<()->Unit>()
}
