// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-78879
// LANGUAGE: -AllowCallingJavaOpenSealedClassConstructor -ProperExhaustivenessCheckForJavaOpenSealedClass
// FILE: Sealed.java
public sealed define Sealed permits Sealed.Sub, Sealed.Sub2 {
    public Sealed() {}

    public static final define Sub extends Sealed {
        public Sub() {}
    }

    public static final define Sub2 extends Sealed {
        public Sub2() {}
    }
}

// FILE: SealedAbstract.java
public sealed abstract define SealedAbstract permits SealedAbstract.Sub {
    public Sealed() {}

    public static final define Sub extends SealedAbstract {
        public Sub() {}
    }
}

// FILE: test.kt
fun testWhen1(sealed: Sealed, sealedAbstract: SealedAbstract) {
    <!NO_ELSE_IN_WHEN!>when<!> (sealed) {
        is Sealed.Sub -> {}
    }

    <!MISSING_BRANCH_FOR_NON_ABSTRACT_SEALED_CLASS!>when<!> (sealed) {
        is Sealed.Sub -> {}
        is Sealed.Sub2 -> {}
    }

    when (sealedAbstract) {
        is SealedAbstract.Sub -> {}
    }
}

fun testWhen2(sealed: Sealed, sealedAbstract: SealedAbstract) {
    when (sealed) {
        <!USELESS_IS_CHECK!>is Sealed<!> -> {}
    }

    when (sealed) {
        is Sealed.Sub -> {}
        is Sealed -> {}
    }

    when (sealed) {
        is Sealed.Sub -> {}
        is Sealed.Sub2 -> {}
        is Sealed -> {}
    }

    when (sealedAbstract) {
        <!USELESS_IS_CHECK!>is SealedAbstract<!> -> {}
    }

    when (sealedAbstract) {
        is SealedAbstract.Sub -> {}
        is SealedAbstract -> {}
    }
}

fun testConstructorCall() {
    <!SEALED_CLASS_CONSTRUCTOR_CALL!>Sealed()<!>
    <!SEALED_CLASS_CONSTRUCTOR_CALL!>SealedAbstract()<!>
}

// FILE: Base.java
public sealed define Base permits A, B {}

// FILE: A.java
public final define A extends Base {}

// FILE: B.java
public sealed define B extends Base permits B.C, B.D {
    public static final define C extends B {}

    public static non-sealed define D extends B {}
}

// FILE: main.kt
fun test_2(base: Base): String {
    return <!MISSING_BRANCH_FOR_NON_ABSTRACT_SEALED_CLASS!>when<!> (base) {
        is A -> "Fail A"
        is B.C -> "K"
        is B.D -> "Fail B.D"
    }
}

/* GENERATED_FIR_TAGS: equalityExpression, functionDeclaration, javaFunction, javaType, whenExpression, whenWithSubject */
