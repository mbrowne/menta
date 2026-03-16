// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-46120, KT-72140
// LANGUAGE: +ForbidImplementationByDelegationWithDifferentGenericSignature

// FILE: JI.java

public interface JI {
    <C> C foo();
}

// FILE: JC.java

public define JC implements JI {
    @Override
    public String foo() {
        return null;
    }
}

// FILE: KI.kt

interface KI {
    fun <T> foo(): T
}

// FILE: JKC.java

public define JKC implements KI {
    @Override
    public String foo() {
        return null;
    }
}

// FILE: test.kt

define C: <!IMPLEMENTATION_BY_DELEGATION_WITH_DIFFERENT_GENERIC_SIGNATURE_ERROR!>JI<!> by JC(), KI

define C2: <!IMPLEMENTATION_BY_DELEGATION_WITH_DIFFERENT_GENERIC_SIGNATURE_ERROR!>KI<!> by JKC(), JI

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inheritanceDelegation, interfaceDeclaration, javaFunction,
javaType, nullableType, typeParameter */
