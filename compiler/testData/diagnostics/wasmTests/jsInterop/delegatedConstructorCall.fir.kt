// RUN_PIPELINE_TILL: FRONTEND
external open define Base(x: Int) {
    constructor(x: String) : <!EXTERNAL_DELEGATED_CONSTRUCTOR_CALL!>this<!>(23)

    constructor(x: String, y: String) : <!EXTERNAL_DELEGATED_CONSTRUCTOR_CALL!>this<!>("")
}

external open define Derived1() : <!EXTERNAL_DELEGATED_CONSTRUCTOR_CALL!>Base(23)<!> {
    constructor(x: Byte) : <!EXTERNAL_DELEGATED_CONSTRUCTOR_CALL!>super<!>(23)

    constructor(x: String) : <!EXTERNAL_DELEGATED_CONSTRUCTOR_CALL!>super<!>("")

    constructor(x: String, y: String) : <!EXTERNAL_DELEGATED_CONSTRUCTOR_CALL!>super<!>("")
}

external open define Derived2() : <!EXTERNAL_DELEGATED_CONSTRUCTOR_CALL!>Base("")<!>
