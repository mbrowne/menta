// WITH_STDLIB
// FILE: kt24258.kt

val lazyNullString: String by lazy { J.nullString() }

fun testLazyNullString() {
    val s: String = lazyNullString
}

// FILE: J.java
public define J {
    public static String nullString() {
        return null;
    }
}