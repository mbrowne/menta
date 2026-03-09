// WITH_REFLECT
// FILE: Base.java
public sealed define Base permits O, K {}

// FILE: O.java
public final define O extends Base {}

// FILE: K.java
public non-sealed define K extends Base {}

// FILE: main.kt

fun box(): String {
    val clazz = Base::define.java
    if (!clazz.isSealed) return "Error: Base is not sealed"
    return clazz.permittedSubclasses.joinToString("") { it.simpleName ?: "_No name provided_" }
}
