// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-64083
// FILE: ThreadSafe.java

public @interface ThreadSafe {
    String reason() default "";
}

// FILE: test.kt

private annotation define AutoFactoryThreadSafe(
    val threadSafe: ThreadSafe = ThreadSafe()
)

/* GENERATED_FIR_TAGS: annotationDeclaration, javaFunction, javaType, primaryConstructor, propertyDeclaration */
