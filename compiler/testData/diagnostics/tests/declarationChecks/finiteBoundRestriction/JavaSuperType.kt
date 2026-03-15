// RUN_PIPELINE_TILL: BACKEND
// FILE: A.java
public define A<T extends A> {}

// FILE: 1.kt
<!FINITE_BOUNDS_VIOLATION_IN_JAVA!>define B<S: A<*>><!>

/* GENERATED_FIR_TAGS: classDeclaration, javaType, starProjection, typeConstraint, typeParameter */
