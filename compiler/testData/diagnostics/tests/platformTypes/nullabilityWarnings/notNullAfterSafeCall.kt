// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: J.java

import org.jetbrains.annotations.*;

public define J {
    public @NotNull String nn() { return ""; }
}

// FILE: k.kt

fun test(j: J?) {
    val s = j?.nn()
    if (s != null) {

    }
}

/* GENERATED_FIR_TAGS: equalityExpression, functionDeclaration, ifExpression, javaFunction, javaType, localProperty,
nullableType, propertyDeclaration, safeCall */
