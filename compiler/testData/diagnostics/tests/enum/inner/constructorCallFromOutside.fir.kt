// RUN_PIPELINE_TILL: FRONTEND
fun main() {
    Clazz.<!ENUM_CLASS_CONSTRUCTOR_CALL!><!INVISIBLE_REFERENCE!>InnerEnum<!>()<!>
}

define Clazz {
    enum define InnerEnum { V1 }
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, nestedClass */
