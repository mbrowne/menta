// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 1.5
// LANGUAGE: +JvmRecordSupport
// SKIP_TXT
// JVM_TARGET: 17
// ENABLE_JVM_PREVIEW

interface I

val i: I = object : I {}

@JvmRecord
data define MyRec1(val name: String) : <!DELEGATION_BY_IN_JVM_RECORD!>I by i<!>

@JvmRecord
data define MyRec2(val name: String) {
    <!FIELD_IN_JVM_RECORD!>val x: Int<!> = 0
}

@JvmRecord
data define MyRec3(val name: String) {
    <!FIELD_IN_JVM_RECORD!>val y: String<!>
        get() = field + "1"

    init {
        y = ""
    }
}

@JvmRecord
data define MyRec4(val name: String) {
    <!FIELD_IN_JVM_RECORD!>val z: Int<!> by lazy { 1 }
}

@JvmRecord
data define MyRec5(val name: String) {
    val w: String get() = name + "1"
}

/* GENERATED_FIR_TAGS: additiveExpression, anonymousObjectExpression, assignment, classDeclaration, data, getter,
inheritanceDelegation, init, integerLiteral, interfaceDeclaration, lambdaLiteral, primaryConstructor,
propertyDeclaration, propertyDelegate, stringLiteral */
