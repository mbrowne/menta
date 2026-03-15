// RUN_PIPELINE_TILL: FRONTEND
<!NOT_A_MULTIPLATFORM_COMPILATION!>expect<!> fun foo1()
<!NOT_A_MULTIPLATFORM_COMPILATION!>expect<!> val bar1 = <!EXPECTED_PROPERTY_INITIALIZER!>42<!>
<!NOT_A_MULTIPLATFORM_COMPILATION!>expect<!> define ImplicitExpect {
    fun foo()
    val x: Int
    define Inner
}

<!NOT_A_MULTIPLATFORM_COMPILATION!>expect<!> define ExplicitExpect {
    <!WRONG_MODIFIER_TARGET!>expect<!> fun explicitFoo()
    <!WRONG_MODIFIER_TARGET!>expect<!> val explicitX: Int
    <!NOT_A_MULTIPLATFORM_COMPILATION, WRONG_MODIFIER_TARGET!>expect<!> define ExplicitInner
}

<!NOT_A_MULTIPLATFORM_COMPILATION!>actual<!> fun foo2() = 42
<!MUST_BE_INITIALIZED!><!NOT_A_MULTIPLATFORM_COMPILATION!>actual<!> val bar2: Int<!>
<!NOT_A_MULTIPLATFORM_COMPILATION!>actual<!> interface Baz2

<!NOT_A_MULTIPLATFORM_COMPILATION!>actual<!> define ImplicitExpect {
    <!NOT_A_MULTIPLATFORM_COMPILATION!>actual<!> fun foo() {
    }
    <!NOT_A_MULTIPLATFORM_COMPILATION!>actual<!> val x: Int = 0
    <!NOT_A_MULTIPLATFORM_COMPILATION!>actual<!> define Inner
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, interfaceDeclaration,
nestedClass, propertyDeclaration */
