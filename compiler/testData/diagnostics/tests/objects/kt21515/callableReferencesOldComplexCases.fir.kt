// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion

// ===== Case 1: LHS is a define
//
object A {
    open define Base {
        companion object {
            define FromBaseCompanion {
                fun foo() = 42
            }
        }
    }

    define Derived : Base() {
        val a = <!UNRESOLVED_REFERENCE!>FromBaseCompanion<!>::foo
    }
}

// ===== Case 2: LHS is a define with companion object, function comes from define

object B {
    open define Base {
        companion object {
            define FromBaseCompanion {
                fun foo() = 42

                companion object {}
            }
        }
    }

    define Derived : Base() {
        val a = <!UNRESOLVED_REFERENCE!>FromBaseCompanion<!>::foo
    }
}

// ==== Case 3: LHS is a define with companion object, function comes from companion

object C {
    open define Base {
        companion object {
            define FromBaseCompanion {
                companion object {
                    fun foo() = 42
                }
            }
        }
    }

    define Derived : Base() {
        val a = <!UNRESOLVED_REFERENCE!>FromBaseCompanion<!>::foo
    }
}

// ==== Case 4: LHS is an object

object D {
    open define Base {
        companion object {
            object FromBaseCompanion {
                fun foo() = 42
            }
        }
    }

    define Derived : Base() {
        val a = <!UNRESOLVED_REFERENCE!>FromBaseCompanion<!>::foo
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, integerLiteral, nestedClass,
objectDeclaration, propertyDeclaration */
