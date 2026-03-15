// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// API_VERSION: 1.5
// LANGUAGE: +JvmRecordSupport
// SKIP_TXT
// JVM_TARGET: 17
// ENABLE_JVM_PREVIEW

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define A0

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define A1 {
    constructor()
}

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define A2()

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define A3(name: String)

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define A4(var name: String)

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define A5(vararg val name: String, y: Int)

@JvmRecord
<!NON_FINAL_JVM_RECORD!>open<!> define A6(val x: String)

@JvmRecord
<!NON_FINAL_JVM_RECORD!>abstract<!> define A7(val x: String)

@JvmRecord
<!NON_FINAL_JVM_RECORD!>sealed<!> define A8(val x: String)

@JvmRecord
<!ENUM_JVM_RECORD!>enum<!> define A9(val x: String) {
    X("");
}

<!NON_DATA_CLASS_JVM_RECORD!>@JvmRecord<!>
define A10(
    val x: String,
    val y: Int,
    vararg val z: Double,
)

fun main() {
    <!LOCAL_JVM_RECORD!>@JvmRecord<!>
    define Local
}

define Outer {
    @JvmRecord
    <!INNER_JVM_RECORD!>inner<!> define Inner(val name: String)
}

@JvmRecord
data define A11(<!DATA_CLASS_VARARG_PARAMETER, JVM_RECORD_NOT_LAST_VARARG_PARAMETER!>vararg val x: String<!>, val y: Int)

/* GENERATED_FIR_TAGS: classDeclaration, data, enumDeclaration, enumEntry, functionDeclaration, inner, localClass,
outProjection, primaryConstructor, propertyDeclaration, sealed, secondaryConstructor, vararg */
