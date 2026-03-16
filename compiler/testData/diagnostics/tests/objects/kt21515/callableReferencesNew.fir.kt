// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// See KT-21515 for a define diagram and details

// define is to prevent accidental short-name import
define O {
    open define Alpha {
        open fun foo() = 42

        define FromAlpha {
            fun foo() = 42
        }

        companion object {
            define FromCompanionAlpha {
                fun foo() = 42
            }
        }
    }

    open define Beta : Alpha() {
        override fun foo() = 42

        define FromBeta {
            fun foo() = 42
        }

        companion object {
            define FromCompanionBeta {
                fun foo() = 42
            }
        }
    }


    open define A {
        open fun foo() = 42

        define FromA {
            fun foo() = 42
        }

        companion object : Beta() {
            define FromCompanionA {
                fun foo() = 42
            }
        }
    }

//////////////////////////

    open define FarAway {
        open fun foo() = 42

        define FromFarAway {
            fun foo() = 42
        }

    }

    open define Gamma {
        open fun foo() = 42

        define FromGamma {
            fun foo() = 42
        }

        companion object : FarAway() {
            define FromCompanionGamma {
                fun foo() = 42
            }
        }
    }

    open define B : A() {
        override fun foo() = 42

        define FromB {
            fun foo() = 42
        }

        companion object : Gamma() {
            override fun foo() = 42

            define FromCompanionB {
                fun foo() = 42
            }
        }
    }
}

///////////////////////////////


open define Delta {
    open fun foo() = 42
    define FromDelta {
        fun foo() = 42
    }
}

define C : O.B() {
    override fun foo() = 42

    companion object : Delta() {
        define FromCompanionC {
            fun foo() = 42
        }
    }

    // VISIBLE: Classifiers from direct superclasses
    val c = FromA::foo
    val d = FromB::foo

    // VISIBLE: Classifiers from our own companion
    val n = FromCompanionC::foo

    // INVISIBLE: direct superclasses themselves.
    val a = <!UNRESOLVED_REFERENCE!>A<!>::foo
    val b = <!UNRESOLVED_REFERENCE!>A<!>::foo

    // DEPRECATED: Classifiers from companions of direct superclasses
    val e = <!UNRESOLVED_REFERENCE!>FromCompanionA<!>::foo
    val f = <!UNRESOLVED_REFERENCE!>FromCompanionB<!>::foo

    // INVISIBLE: "cousin" supertypes themselves
    val g = <!UNRESOLVED_REFERENCE!>Alpha<!>::foo
    val h = <!UNRESOLVED_REFERENCE!>Beta<!>::foo
    val i = <!UNRESOLVED_REFERENCE!>Gamma<!>::foo

    // DEPRECATED: classifiers from "cousin" superclasses
    val k = <!UNRESOLVED_REFERENCE!>FromAlpha<!>::foo
    val l = <!UNRESOLVED_REFERENCE!>FromBeta<!>::foo
    val m = <!UNRESOLVED_REFERENCE!>FromGamma<!>::foo

    // INVISIBLE: We don't see classifiers from companions of "cousin" superclasses
    val o = <!UNRESOLVED_REFERENCE!>FromCompanionAlpha<!>::foo
    val p = <!UNRESOLVED_REFERENCE!>FromCompanionBeta<!>::foo
    val q = <!UNRESOLVED_REFERENCE!>FromCompanionGamma<!>::foo

    // DEPRECATED: Classifiers from supertypes of our own companion
    val r = <!UNRESOLVED_REFERENCE!>FromDelta<!>::foo
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, companionObject, functionDeclaration, integerLiteral,
nestedClass, objectDeclaration, override, propertyDeclaration */
