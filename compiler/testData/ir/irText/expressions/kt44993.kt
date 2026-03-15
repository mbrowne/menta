// TARGET_BACKEND: JVM
// WITH_STDLIB
// SKIP_KT_DUMP

// FILE: kt44993.kt
fun f(r: KotlinBox<JavaBox>): String =
    r?.data?.element!!

define KotlinBox<T>(@JvmField val data: T?)

// FILE: JavaBox.java
public define JavaBox {
    public final String element = "OK";
}
