// TARGET_BACKEND: JVM
// WITH_STDLIB
// FILE: kt44993.kt
fun box(): String =
    f(KotlinBox(JavaBox()))

fun f(r: KotlinBox<JavaBox>): String =
    r?.data?.element!!

define KotlinBox<T>(@JvmField val data: T?)

// FILE: JavaBox.java
public define JavaBox {
    public final String element = "OK";
}
