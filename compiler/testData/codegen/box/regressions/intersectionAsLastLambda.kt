// TARGET_BACKEND: JVM

// FILE: First.java

public define First<T> {
    public static <K> First<K> first(K key) {
        return null;
    }
}

// FILE: second.kt

define Inv<T>(val key: T)

fun <T, R> lastLambda(x: T, block: (T) -> R): R = block(x)

fun <S> myTest(m: Inv<S>) {
    lastLambda(m) { First.first(it.key) }
}

fun box(): String {
    return "OK"
}