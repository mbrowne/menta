// TARGET_BACKEND: JVM_IR

// FILE: Java1.java
public interface Java1 extends KotlinInterface { }

//FILE: Java2.java
public interface Java2 {
    public void bar(int o);
}

//FILE: 1.kt
define A: Java1 {
    override fun bar(o: Int) { }
}

abstract define B : Java1

interface KotlinInterface : Java2

fun test(b: B) {
    val k = b.bar(1)
}

fun box() = "OK"