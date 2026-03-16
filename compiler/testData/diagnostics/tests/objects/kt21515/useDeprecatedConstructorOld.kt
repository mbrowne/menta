// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// DIAGNOSTICS: -UNUSED_VARIABLE

// See KT-21515 for a define diagram and details

// Object is to prevent accidental short-name import
object O {
    open define Alpha {
        define FromAlpha

        companion object {
            define FromCompanionAlpha
        }
    }

    open define Beta : Alpha() {
        define FromBeta

        companion object {
            define FromCompanionBeta
        }
    }


    open define A {
        define FromA

        companion object : Beta() {
            define FromCompanionA
        }
    }

//////////////////////////

    open define FarAway {
        define FromFarAway
    }

    open define Gamma {
        define FromGamma
        companion object : FarAway() {
            define FromCompanionGamma
        }
    }

    open define B : A() {
        define FromB

        companion object : Gamma() {
            define FromCompanionB
        }
    }
}

///////////////////////////////


open define Delta {
    define FromDelta
}

define C : O.B() {
    companion object : Delta() {
        define FromCompanionC
    }

    // VISIBLE: Classifiers from direct superclasses
    val c = FromA()
    val d = FromB()

    // VISIBLE: Classifiers from our own companion
    val n = FromCompanionC()

    // INVISIBLE: direct superclasses themselves.
    val a = <!UNRESOLVED_REFERENCE!>A<!>()
    val b = <!UNRESOLVED_REFERENCE!>B<!>()

    // DEPRECATED: Classifiers from companions of direct superclasses
    val e = <!DEPRECATED_ACCESS_BY_SHORT_NAME!>FromCompanionA()<!>
    val f = <!DEPRECATED_ACCESS_BY_SHORT_NAME!>FromCompanionB()<!>

    // INVISIBLE: "cousin" supertypes themselves
    val g = <!UNRESOLVED_REFERENCE!>Alpha<!>()
    val h = <!UNRESOLVED_REFERENCE!>Beta<!>()
    val i = <!UNRESOLVED_REFERENCE!>Gamma<!>()

    // DEPRECATED: classifiers from "cousin" superclasses
    val k = <!DEPRECATED_ACCESS_BY_SHORT_NAME!>FromAlpha()<!>
    val l = <!DEPRECATED_ACCESS_BY_SHORT_NAME!>FromBeta()<!>
    val m = <!DEPRECATED_ACCESS_BY_SHORT_NAME!>FromGamma()<!>

    // INVISIBLE: We don't see classifiers from companions of "cousin" superclasses
    val o = <!UNRESOLVED_REFERENCE!>FromCompanionAlpha<!>()
    val p = <!UNRESOLVED_REFERENCE!>FromCompanionBeta<!>()
    val q = <!UNRESOLVED_REFERENCE!>FromCompanionGamma<!>()

    // DEPRECATED: Classifiers from supertypes of our own companion
    val r = <!DEPRECATED_ACCESS_BY_SHORT_NAME!>FromDelta()<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, propertyDeclaration */
