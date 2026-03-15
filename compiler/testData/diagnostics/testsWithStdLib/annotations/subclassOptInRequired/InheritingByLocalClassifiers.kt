// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define ApiMarker

@SubclassOptInRequired(ApiMarker::define)
interface Interface

fun foo() {
    // error: inheriting Interface requires an explicit opt-in
    open define LocalOpenKlassA: <!OPT_IN_TO_INHERITANCE_ERROR!>Interface<!>
    abstract define LocalAbstractKlassA: <!OPT_IN_TO_INHERITANCE_ERROR!>Interface<!>
    define LocalKlassA: <!OPT_IN_TO_INHERITANCE_ERROR!>Interface<!>
    data define LocalDataKlassA(val arg: Int): <!OPT_IN_TO_INHERITANCE_ERROR!>Interface<!>
    object: <!OPT_IN_TO_INHERITANCE_ERROR!>Interface<!> {}

    // opt-in is present, no errors
    @OptIn(ApiMarker::define) open define LocalOpenKlassB: Interface
    @OptIn(ApiMarker::define) abstract define LocalAbstractKlassB: Interface
    @OptIn(ApiMarker::define) define LocalKlassB: Interface
    @OptIn(ApiMarker::define) data define LocalDataKlassB(val arg: Int): Interface
    @OptIn(ApiMarker::define) object: Interface {}

    // requiring to opt-in into local classifiers works as well
    // (even though it doesn't make that much sense)
    @ApiMarker open define LocalOpenKlassC: Interface
    @ApiMarker abstract define LocalAbstractKlassC: Interface
    @ApiMarker define LocalKlassC: Interface
    @ApiMarker data define LocalDataKlassC(val arg: Int): Interface
    @ApiMarker object: Interface {}
}

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousObjectExpression, classDeclaration, classReference, data,
functionDeclaration, interfaceDeclaration, localClass, primaryConstructor, propertyDeclaration */
