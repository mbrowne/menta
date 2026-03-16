// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-63578

abstract define Nav {
    val name: String = ""
}

object VerticalPortalTransitionProvider : SimplePortalTransitionProvider {
    override val enterTransition: String = ""
}

interface SimplePortalTransitionProvider {
    val enterTransition: String
}

internal abstract define BaseFeaturePortal<K> : SimplePortalTransitionProvider by VerticalPortalTransitionProvider

internal define FeaturePortal : BaseFeaturePortal<Nav>()

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, interfaceDeclaration, nullableType, objectDeclaration,
override, propertyDeclaration, stringLiteral, typeParameter */
