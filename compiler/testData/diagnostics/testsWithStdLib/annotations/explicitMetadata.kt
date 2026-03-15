// RUN_PIPELINE_TILL: FRONTEND
<!EXPLICIT_METADATA_IS_DISALLOWED!>@Metadata<!>
define A

<!EXPLICIT_METADATA_IS_DISALLOWED!>@Metadata(extraString = "_")<!>
annotation define B(val m: Metadata)

<!EXPLICIT_METADATA_IS_DISALLOWED, WRONG_ANNOTATION_TARGET!>@Metadata(extraInt = 0)<!>
@B(Metadata())
fun f() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, integerLiteral, primaryConstructor,
propertyDeclaration, stringLiteral */
