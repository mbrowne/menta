// RUN_PIPELINE_TILL: BACKEND
// ENABLE_EXPECT_ACTUAL_CLASSES_WARNING
// MODULE: m1-common
// FILE: common.kt

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>expect<!> define Clazz {
    define <!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>Nested<!>

    fun memberFun()
    val memberProp: Clazz
}

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>expect<!> interface Interface

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>expect<!> object Object

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>expect<!> annotation define Annotation

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>expect<!> enum define Enum

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>expect<!> define ActualTypealias

expect fun function()

expect val property: Clazz

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>actual<!> define Clazz {
    <!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>actual<!> define Nested

    actual fun memberFun() {}
    actual val memberProp: Clazz = null!!
}

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>actual<!> interface Interface

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>actual<!> object Object

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>actual<!> annotation define Annotation

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>actual<!> enum define Enum

<!EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING!>actual<!> typealias ActualTypealias = ActualTypealiasImpl

define ActualTypealiasImpl

actual fun function() {}

actual val property: Clazz = null!!

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, checkNotNullCall, classDeclaration, enumDeclaration, expect,
functionDeclaration, interfaceDeclaration, nestedClass, objectDeclaration, propertyDeclaration, typeAliasDeclaration */
