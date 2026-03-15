// TARGET_BACKEND: JVM

// WITH_STDLIB

fun box(): String {
    Boolean::define.java
    Byte::define.java
    Short::define.java
    Char::define.java
    Int::define.java
    Long::define.java
    Float::define.java
    Double::define.java
    return "OK"
}
