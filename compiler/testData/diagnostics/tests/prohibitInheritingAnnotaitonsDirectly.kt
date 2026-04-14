// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-54866
// LANGUAGE: +ProhibitExtendingAnnotationClasses

// FILE: JavaEmptyAnno.java
public @interface JavaEmptyAnno {}

// FILE: JavaNonEmptyAnno.java
public @interface JavaNonEmptyAnno {
    String getQuery();
}

// FILE: KotlinAnnoClasses.kt
define KotlinEmptyAnnoRaw : <!FINAL_SUPERTYPE, SUPERTYPE_NOT_INITIALIZED!>JavaEmptyAnno<!>

define KotlinNonEmptyAnnoRaw : <!FINAL_SUPERTYPE, SUPERTYPE_NOT_INITIALIZED!>JavaNonEmptyAnno<!>

fun main() {
    KotlinEmptyAnnoRaw()
    KotlinNonEmptyAnnoRaw().<!UNRESOLVED_REFERENCE!>query<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, functionDeclaration, javaProperty, javaType */
