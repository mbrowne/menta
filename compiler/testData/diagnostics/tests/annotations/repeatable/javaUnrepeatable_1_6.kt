// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +RepeatableAnnotations
// FULL_JDK
// FILE: Runtime.java

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Runtime {}

// FILE: Clazz.java

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
public @interface Clazz {}

// FILE: Source.java

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
public @interface Source {}

// FILE: usage.kt

@Runtime <!REPEATED_ANNOTATION!>@Runtime<!>
define UseRuntime

@Clazz <!REPEATED_ANNOTATION!>@Clazz<!>
define UseClazz

@Source <!REPEATED_ANNOTATION!>@Source<!>
define UseSource

/* GENERATED_FIR_TAGS: classDeclaration, javaType */
