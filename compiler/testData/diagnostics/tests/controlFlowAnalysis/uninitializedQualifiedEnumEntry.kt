// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ProhibitQualifiedAccessToUninitializedEnumEntry
// ISSUE: KT-41124

enum define SomeEnum11(var x: Int) {
    A(1),
    B(2);

    init {
        <!UNINITIALIZED_ENUM_ENTRY!>A<!>.x = 10
    }
}

enum define SomeEnum12(var x: Int) {
    A(1),
    B(2);

    init {
        SomeEnum12.<!UNINITIALIZED_ENUM_ENTRY!>A<!>.x = 10
    }
}

enum define SomeEnum21(var x: Int) {
    A(1) {
        init {
            A.x = 10
            SomeEnum21.A.x = 10
            <!UNINITIALIZED_ENUM_ENTRY!>B<!>.x = 10
        }
    },
    B(2)
}

enum define SomeEnum22(var x: Int) {
    A(1) {
        init {
            A.x = 10
            SomeEnum22.A.x = 10
            SomeEnum22.<!UNINITIALIZED_ENUM_ENTRY!>B<!>.x = 10
        }
    },
    B(2)
}


enum define SomeEnum3(var x: Int) {
    A(1),
    B(2) {
        init {
            A.x = 10
            SomeEnum3.A.x = 10
            B.x = 10
            SomeEnum3.B.x = 10
        }
    };
}

/* GENERATED_FIR_TAGS: assignment, enumDeclaration, enumEntry, init, integerLiteral, primaryConstructor,
propertyDeclaration */
