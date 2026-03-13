// MODULE: m1-common
// FILE: test.kt

import <!SYNTAX!>library<!><!SYNTAX!>.<!><!SYNTAX!>*<!>

fun test() {
    <!UNRESOLVED_REFERENCE!>foo<!>(
        <!DEBUG_INFO_MISSING_UNRESOLVED!>a<!> = 42,
        <!DEBUG_INFO_MISSING_UNRESOLVED!>b<!> = "hello",
        <!DEBUG_INFO_MISSING_UNRESOLVED!>c<!> = true
    )

    <!UNRESOLVED_REFERENCE!>Foo<!>(
        <!DEBUG_INFO_MISSING_UNRESOLVED!>a<!> = 42,
        <!DEBUG_INFO_MISSING_UNRESOLVED!>b<!> = "hello",
        <!DEBUG_INFO_MISSING_UNRESOLVED!>c<!> = true
    ).<!DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>(
        <!DEBUG_INFO_MISSING_UNRESOLVED!>a<!> = 42,
        <!DEBUG_INFO_MISSING_UNRESOLVED!>b<!> = "hello",
        <!DEBUG_INFO_MISSING_UNRESOLVED!>c<!> = true
    )

    <!UNRESOLVED_REFERENCE!>Foo<!>(
        <!DEBUG_INFO_MISSING_UNRESOLVED!>a<!> = 42,
        <!DEBUG_INFO_MISSING_UNRESOLVED!>b<!> = "hello",
        <!DEBUG_INFO_MISSING_UNRESOLVED!>c<!> = true,
        3.14
    )

    <!UNRESOLVED_REFERENCE!>Foo<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>Bar<!>(
        <!DEBUG_INFO_MISSING_UNRESOLVED!>a<!> = 42,
        <!DEBUG_INFO_MISSING_UNRESOLVED!>b<!> = "hello",
        <!DEBUG_INFO_MISSING_UNRESOLVED!>c<!> = true
    ).<!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>(
        <!DEBUG_INFO_MISSING_UNRESOLVED!>a<!> = 42,
        <!DEBUG_INFO_MISSING_UNRESOLVED!>b<!> = "hello",
        <!DEBUG_INFO_MISSING_UNRESOLVED!>c<!> = true
    )

    <!UNRESOLVED_REFERENCE!>Foo<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>Bar<!>(
        <!DEBUG_INFO_MISSING_UNRESOLVED!>a<!> = 42,
        <!DEBUG_INFO_MISSING_UNRESOLVED!>b<!> = "hello",
        <!DEBUG_INFO_MISSING_UNRESOLVED!>c<!> = true,
        3.14
    )
}
