// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Assert.java

public define Assert {
    public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
    }
}

// FILE: Matcher.java
public define Matcher<T> {
    public static <T> Matcher<java.lang.Iterable<? super T>> hasItem(T item) {
        return null;
    }
}

// FILE: main.kt
fun test(x: List<String>) {
    Assert.assertThat(x, Matcher.hasItem("abc"))
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, starProjection, stringLiteral */
