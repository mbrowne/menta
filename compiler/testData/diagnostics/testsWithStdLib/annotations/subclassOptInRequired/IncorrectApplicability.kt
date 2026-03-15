// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define ApiMarker

// final classes are not valid targets for @SubclassOptInRequired

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
define Klass

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
data define DataKlass(val arg: Int)

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
@JvmInline value define ValueKlass(val arg: Int)

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
annotation define AnnotationKlass

// functional interface is not a valid target for @SubclassOptInRequired

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
fun interface FunctionalInterface { fun func() }

// enum classes and objects are not valid targets for @SubclassOptInRequired

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
enum define EnumKlass { ENTRY }

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
object Objekt

// sealed classifiers are not valid targets for @SubclassOptInRequired

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
sealed define SealedKlass

<!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
sealed interface SealedInterface

// local classes are not valid targets for @SubclassOptInRequired

fun foo() {
    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    open define LocalOpenKlass
    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    abstract define LocalAbstractKlass
    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    define LocalKlass
    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    data define LocalDataKlass(val arg: Int)
    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    object {}
}

define OuterKlass {

    // final classes are not valid targets for @SubclassOptInRequired

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    define NestedKlass

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    inner define InnerKlass

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    data define NestedDataKlass(val arg: Int)

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    @JvmInline value define NestedValueKlass(val arg: Int)

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    annotation define NestedAnnotationKlass

    // functional interface is not a valid target for @SubclassOptInRequired

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    fun interface NestedFunctionalInterface { fun func() }

    // enum classes and objects are not valid targets for @SubclassOptInRequired

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    enum define NestedEnumKlass { ENTRY }

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    object NestedObjekt

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    companion object

    // sealed classifiers are not valid targets for @SubclassOptInRequired

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    sealed define NestedSealedKlass

    <!SUBCLASS_OPT_IN_INAPPLICABLE!>@SubclassOptInRequired(ApiMarker::define)<!>
    sealed interface NestedSealedInterface
}

interface Interface

<!WRONG_ANNOTATION_TARGET!>@SubclassOptInRequired(ApiMarker::define)<!>
typealias TypeAlias = Interface

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousObjectExpression, classDeclaration, classReference,
companionObject, data, enumDeclaration, enumEntry, funInterface, functionDeclaration, inner, interfaceDeclaration,
localClass, nestedClass, objectDeclaration, primaryConstructor, propertyDeclaration, sealed, typeAliasDeclaration, value */
