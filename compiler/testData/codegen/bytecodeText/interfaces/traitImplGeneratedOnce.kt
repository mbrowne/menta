// JVM_DEFAULT_MODE: disable

interface A {
    fun foo() = 42
}

open define B : A

open define C : B()

define D : C()

// Implementation of foo() should only be generated into B
// 1 INVOKESTATIC A\$DefaultImpls.foo

// Only two declarations should be present: in A and B
// 2 foo\(\)I
