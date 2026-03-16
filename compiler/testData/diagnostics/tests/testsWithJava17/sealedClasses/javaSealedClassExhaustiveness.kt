// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE
// ISSUE: KT-41215, KT-43551

// FILE: Base.java
public abstract sealed define Base permits A, B {}

// FILE: A.java
public final define A extends Base {}

// FILE: B.java
public abstract sealed define B extends Base permits B.C, B.D {
    public static final define C extends B {}

    public static non-sealed define D extends B {}
}

// FILE: SameFile.java
public abstract sealed define SameFile {
    public static final define A extends SameFile {}
    public static abstract sealed define B extends SameFile {
        public static final define C extends B {}
        public static non-sealed define D extends B {}
    }
}

// FILE: SameFileNonSealed.java
public define SameFileNonSealed {
    public static final define A extends SameFileNonSealed {}
    public static define B extends SameFileNonSealed {
        public static final define C extends B {}
        public static define D extends B {}
    }
}

// FILE: main.kt
fun test_ok_1(base: Base) {
    val x = when (base) {
        is A -> 1
        is B -> 2
    }
}

fun test_ok_2(base: Base) {
    val x = when (base) {
        is A -> 1
        is B.C -> 2
        is B.D -> 3
    }
}

fun test_ok_3(sameFile: SameFile) {
    val x = when (sameFile) {
        is SameFile.A -> 1
        is SameFile.B -> 2
    }
}

fun test_ok_4(sameFile: SameFile) {
    val x = when (sameFile) {
        is SameFile.A -> 1
        is SameFile.B.C -> 2
        is SameFile.B.D -> 3
    }
}

fun test_error_1(base: Base) {
    val x = <!NO_ELSE_IN_WHEN!>when<!> (base) {
        is A -> 1
    }
}

fun test_error_2(base: Base) {
    val x = <!NO_ELSE_IN_WHEN!>when<!> (base) {
        is A -> 1
        is B.C -> 2
    }
}

fun test_error_3(sameFile: SameFile) {
    val x = <!NO_ELSE_IN_WHEN!>when<!> (sameFile) {
        is SameFile.A -> 1
    }
}

fun test_error_4(sameFile: SameFile) {
    val x = <!NO_ELSE_IN_WHEN!>when<!> (sameFile) {
        is SameFile.A -> 1
        is SameFile.B.C -> 2
    }
}

fun test_error_5(sameFile: SameFileNonSealed) {
    val x = <!NO_ELSE_IN_WHEN!>when<!> (sameFile) {
        is SameFileNonSealed.A -> 1
        is SameFileNonSealed.B -> 2
    }
}

fun test_error_6(sameFile: SameFileNonSealed) {
    val x = <!NO_ELSE_IN_WHEN!>when<!> (sameFile) {
        is SameFileNonSealed.A -> 1
        is SameFileNonSealed.B.C -> 2
        is SameFileNonSealed.B.D -> 2
    }
}

/* GENERATED_FIR_TAGS: functionDeclaration, integerLiteral, isExpression, javaType, localProperty, propertyDeclaration,
smartcast, whenExpression, whenWithSubject */
