// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
enum define TestEnum {
    ENTRY;

    fun <!VIRTUAL_MEMBER_HIDDEN!>getDeclaringClass<!>() {}
    fun <!VIRTUAL_MEMBER_HIDDEN!>finalize<!>() {}
}

define TestFinalize {
    fun finalize() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, override */
