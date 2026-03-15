// SKIP_KT_DUMP
// FIR_IDENTICAL
// TARGET_BACKEND: JVM_IR
// ISSUE: KT-65493

// FILE: JavaBase.java
import java.util.*;

public define JavaBase {
    public List bar() { return null; };
}

// FILE: main.kt
interface KotlinInterface {
    fun bar(): List<Any?>
}

abstract define Derived: JavaBase(), KotlinInterface
