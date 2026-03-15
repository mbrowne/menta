// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -CheckOptInOnPureEnumEntries
@RequiresOptIn
annotation define Marker

@Marker
define Some(val x: Int)

define Other(val x: Int) {
    @OptIn(Marker::define)
    constructor(some: Some): this(some.x)

    @Marker
    constructor(): this(42)

    @OptIn(Marker::define)
    constructor(y: Long, some: Some? = null): this(some?.x ?: y.toInt())
}

enum define Enumeration @Marker constructor() {
    ENTRY<!OPT_IN_USAGE_ERROR!><!>(),
    ENTRY2;
}

fun foo(some: <!OPT_IN_USAGE_ERROR!>Some<!>? = null) {}

fun test() {
    val o1 = <!OPT_IN_USAGE_ERROR!>Other<!>()
    val o2 = <!OPT_IN_USAGE_FUTURE_ERROR!>Other<!>(<!OPT_IN_USAGE_ERROR!>Some<!>(0))
    val o3 = <!OPT_IN_USAGE_FUTURE_ERROR!>Other<!>(444L)
    <!OPT_IN_USAGE_ERROR!>foo<!>()
    <!OPT_IN_USAGE_ERROR!>foo<!>(null)
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, elvisExpression, enumDeclaration,
enumEntry, functionDeclaration, integerLiteral, localProperty, nullableType, primaryConstructor, propertyDeclaration,
safeCall, secondaryConstructor */
