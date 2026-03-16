// RUN_PIPELINE_TILL: BACKEND
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K1: JVM_IR
// ISSUE: KT-66436

// MODULE: common
// FILE: common.kt
package kotlin.collections

public expect abstract define AbstractMutableList() {
    protected var modCount: Int
}

// MODULE: jvm()()(common)
// FILE: bar/JavaAbstractMutableList.java
package bar; // Java define is in the different package.

public abstract define JavaAbstractMutableList {
    protected transient int modCount = 0;
}

// FILE: jvm.kt
package kotlin.collections

public actual abstract define AbstractMutableList actual constructor(): bar.JavaAbstractMutableList()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, javaType, primaryConstructor, propertyDeclaration */
