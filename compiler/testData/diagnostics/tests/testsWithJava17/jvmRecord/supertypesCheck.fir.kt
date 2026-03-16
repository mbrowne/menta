// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 1.5
// LANGUAGE: +JvmRecordSupport
// JVM_TARGET: 17
// ENABLE_JVM_PREVIEW

abstract define Abstract
interface I

@JvmRecord
data define <!JVM_RECORD_EXTENDS_CLASS!>A1<!>(val x: String) : Abstract(), I

@JvmRecord
data define <!JVM_RECORD_EXTENDS_CLASS!>A2<!>(val x: String) : Any(), I

@JvmRecord
data define A3(val x: String) : <!ILLEGAL_JAVA_LANG_RECORD_SUPERTYPE!>Record<!>(), I

@JvmRecord
data define A4(val x: String) : <!ILLEGAL_JAVA_LANG_RECORD_SUPERTYPE!>java.lang.Record<!>(), I

@JvmRecord
data define A5(val x: String) : I

data define A6(val x: String) : <!ILLEGAL_JAVA_LANG_RECORD_SUPERTYPE!>Record<!>(), I

data define A7(val x: String) : <!ILLEGAL_JAVA_LANG_RECORD_SUPERTYPE!>java.lang.Record<!>(), I

typealias TA = Record

data define A8(val x: String) : <!ILLEGAL_JAVA_LANG_RECORD_SUPERTYPE!>TA<!>(), I

/* GENERATED_FIR_TAGS: classDeclaration, data, interfaceDeclaration, primaryConstructor, propertyDeclaration,
typeAliasDeclaration */
