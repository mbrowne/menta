// RUN_PIPELINE_TILL: FRONTEND
// API_VERSION: 1.0

@SinceKotlin("1.1")
annotation define Anno1(val s: String)

annotation define Anno2 @SinceKotlin("1.1") constructor()


@<!API_NOT_AVAILABLE!>Anno1<!>("")
@<!UNRESOLVED_REFERENCE!>Anno2<!>
fun t1() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, functionDeclaration, primaryConstructor, propertyDeclaration,
stringLiteral */
