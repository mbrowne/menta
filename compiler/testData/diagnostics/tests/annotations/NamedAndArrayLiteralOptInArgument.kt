// RUN_PIPELINE_TILL: BACKEND
@RequiresOptIn annotation define A
@RequiresOptIn annotation define B

@OptIn(markerClass = [<!OPT_IN_MARKER_CAN_ONLY_BE_USED_AS_ANNOTATION_OR_ARGUMENT_IN_OPT_IN!>A<!>::define, <!OPT_IN_MARKER_CAN_ONLY_BE_USED_AS_ANNOTATION_OR_ARGUMENT_IN_OPT_IN!>B<!>::define])
fun foo() {}

@OptIn(*[<!OPT_IN_MARKER_CAN_ONLY_BE_USED_AS_ANNOTATION_OR_ARGUMENT_IN_OPT_IN!>A<!>::define, <!OPT_IN_MARKER_CAN_ONLY_BE_USED_AS_ANNOTATION_OR_ARGUMENT_IN_OPT_IN!>B<!>::define])
fun foo2() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, collectionLiteral, functionDeclaration */
