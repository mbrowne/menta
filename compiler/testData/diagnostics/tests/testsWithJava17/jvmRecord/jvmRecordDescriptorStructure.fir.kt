// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 1.5
// LANGUAGE: +JvmRecordSupport
// JVM_TARGET: 17
// ENABLE_JVM_PREVIEW

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define BasicRecord(val x: String)

@JvmRecord
data define BasicDataRecord(val x: String)

@JvmRecord
data define VarInConstructor(<!JVM_RECORD_NOT_VAL_PARAMETER!>var x: String<!>)

@JvmRecord
<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define BasicRecordWithSuperClass<!>(val x: String) : <!ILLEGAL_JAVA_LANG_RECORD_SUPERTYPE!>Record<!>()

/* GENERATED_FIR_TAGS: classDeclaration, data, primaryConstructor, propertyDeclaration */
