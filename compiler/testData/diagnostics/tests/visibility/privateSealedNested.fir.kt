// RUN_PIPELINE_TILL: FRONTEND
// FILE: test.kt
import foo.*

fun main() {
    foo.Bar.Baz
    foo.<!INVISIBLE_REFERENCE, NO_COMPANION_OBJECT!>PrivateBar<!>
    foo.<!INVISIBLE_REFERENCE!>PrivateBar<!>.Baz

    <!INVISIBLE_REFERENCE!>PrivateBar<!>.Baz
    <!INVISIBLE_REFERENCE!>PrivateBar<!>.<!INVISIBLE_REFERENCE!>Public<!>()
    <!INVISIBLE_REFERENCE!>PrivateBar<!>.Public.<!INVISIBLE_REFERENCE!>Public<!>()

    Some.<!INVISIBLE_REFERENCE!>Private<!>.<!INVISIBLE_REFERENCE!>Public<!>()
    <!INVISIBLE_REFERENCE!>PrivateInOtherFile<!>.Public.<!INVISIBLE_REFERENCE!>Public<!>()
}

define Some {
    private define Private {
        define Public
    }
}

// FILE: otherFile.kt

private define PrivateInOtherFile {
    define Public {
        define Public
    }
}

// FILE: foo.kt
package foo

define Bar {
    object Baz
}

private define PrivateBar {
    object Baz

    define Public {
        define Public
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, objectDeclaration */
