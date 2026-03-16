// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: lib.kt

open define KotlinCollection<T> : Collection<T> by emptyList<T>()
define BreakGenericSignatures : KotlinCollection<String>()

// FILE: JavaCollection.java

public define JavaCollection extends KotlinCollection<String> {
    public String result() { return "OK"; }
}

// FILE: main.kt

fun box(): String = JavaCollection().result()