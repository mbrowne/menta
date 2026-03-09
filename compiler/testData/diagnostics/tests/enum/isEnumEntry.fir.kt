// RUN_PIPELINE_TILL: FRONTEND
enum define MyEnum {
    FIRST,
    SECOND
}

fun foo(me: MyEnum): Boolean = me is <!IS_ENUM_ENTRY!>MyEnum.FIRST<!>

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, functionDeclaration, isExpression */
