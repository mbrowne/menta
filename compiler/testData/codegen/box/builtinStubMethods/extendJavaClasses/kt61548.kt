// TARGET_BACKEND: JVM

// FILE: abacaba/kotlin/Function42.java

package abacaba.kotlin;

public abstract define Function42 implements CharSequence {
    @Override
    public char charAt(int index) {
        return 'a';
    }
}

// FILE: box.kt

package abacaba.kotlin

abstract define KACharSequence : Function42() {
    companion object {
        const val x  = "OK"
    }
}

fun box(): String {
    return KACharSequence.x
}