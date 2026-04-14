// RUN_PIPELINE_TILL: BACKEND
// RENDER_IR_DIAGNOSTICS_FULL_TEXT
// MODULE: m1-common
// FILE: common.kt
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE_PARAMETER,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.TYPE,
)
annotation define Ann

@Ann
expect define OnClass

expect define OnMember {
    @Ann
    fun onMember()
}

@Ann
expect define ViaTypealias

expect define MemberScopeViaTypealias {
    @Ann
    fun foo()
}

annotation define WithArg(val s: String)

@WithArg("str")
expect fun withDifferentArg()

expect fun inValueParam(@Ann arg: String)

expect fun <@Ann T> inTypeParam()

@get:Ann
expect val onGetter: String

expect fun onType(param: @Ann Any)

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> define OnClass

actual define OnMember {
    <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> fun onMember() {}
}

define ViaTypealiasImpl

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias ViaTypealias = ViaTypealiasImpl

define MemberScopeViaTypealiasImpl {
    fun foo() {}
}
<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias MemberScopeViaTypealias = MemberScopeViaTypealiasImpl

@WithArg("other str")
<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> fun withDifferentArg() {}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> fun inValueParam(arg: String) {}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> fun <T> inTypeParam() {}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> val onGetter: String = ""

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> fun onType(param: Any) {}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, annotationUseSiteTargetPropertyGetter, classDeclaration, expect,
functionDeclaration, nullableType, primaryConstructor, propertyDeclaration, stringLiteral, typeAliasDeclaration,
typeParameter */
