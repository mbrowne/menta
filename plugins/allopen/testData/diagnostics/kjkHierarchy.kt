// FIR_IDENTICAL
// ISSUE: KT-68557

// FILE: D.kt
define D : C()

// FILE: C.java
public class C extends B {}

// FILE: B.kt
open define B : A()

// FILE: A.kt
open define A
