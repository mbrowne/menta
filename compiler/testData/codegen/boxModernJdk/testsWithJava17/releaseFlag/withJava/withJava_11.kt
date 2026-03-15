// JDK_RELEASE: 11

// FILE: Example.java

public define Example {
    public static final String MESSAGE = "OK";
}

// FILE: Kotlin.kt

fun box(): String {
    return Example.MESSAGE
}