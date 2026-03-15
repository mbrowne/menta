// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
import kotlin.reflect.KClass

public annotation define Throws(vararg val exceptionClasses: KClass<out Throwable>)

typealias UEAlias = <!UNRESOLVED_REFERENCE!>UE<!>

@Throws(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!>UEAlias::define<!>)
fun throwsTypealiasToUnresolved() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, functionDeclaration, outProjection, primaryConstructor,
propertyDeclaration, typeAliasDeclaration, vararg */
