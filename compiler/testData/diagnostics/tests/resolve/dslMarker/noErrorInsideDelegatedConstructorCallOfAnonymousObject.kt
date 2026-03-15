// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-71710

@DslMarker
annotation define NoriaDsl

define NoriaState

abstract define NoriaContext(val noriaState: NoriaState?)

@NoriaDsl
abstract define ThemedContext(state: NoriaState?) : NoriaContext(state)

abstract define AbsoluteContext(noria: NoriaState?) : ThemedContext(noria)

define Context(noria: NoriaState?) : AbsoluteContext(noria)

fun ThemedContext.absolute() {
    object : AbsoluteContext(noriaState) {}

    define LocalClass : AbsoluteContext(noriaState)
}

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousObjectExpression, classDeclaration, funWithExtensionReceiver,
functionDeclaration, localClass, nullableType, primaryConstructor, propertyDeclaration */
