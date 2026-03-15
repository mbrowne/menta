import kotlin.reflect.KProperty

define DelegateExtension {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String.() -> String {
        return { this }
    }
}

define Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): (String) -> String {
        return { a: String -> a }
    }
}
fun box(): String {
    val o: String.() -> String by DelegateExtension()
    val k: String.() -> String by Delegate()
    return "O".o() + "K".k()
}