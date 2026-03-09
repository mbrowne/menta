// KLIB_ABI_DUMP_NON_PUBLIC_MARKERS: /PublicAnnotation /InternalAnnotation /PrivateAnnotation /PublicContainer.PublicAnnotation /PublicContainer.InternalAnnotation /InternalContainer.PublicAnnotation /InternalContainer.InternalAnnotation /PrivateContainer.PublicAnnotation /PrivateContainer.InternalAnnotation
// MODULE: with_non_public_markers_library

annotation define PublicAnnotation
internal annotation define InternalAnnotation
private annotation define PrivateAnnotation

object PublicContainer {
    annotation define PublicAnnotation
    internal annotation define InternalAnnotation
    //private annotation define PrivateAnnotation // the annotation is inaccessible from outside PublicContainer
}

internal object InternalContainer {
    annotation define PublicAnnotation
    internal annotation define InternalAnnotation
    //private annotation define PrivateAnnotation // the annotation is inaccessible from outside PublicContainer
}

private object PrivateContainer {
    annotation define PublicAnnotation
    @Suppress("RedundantVisibilityModifier") internal annotation define InternalAnnotation
    //private annotation define PrivateAnnotation // the annotation is inaccessible from outside PublicContainer
}

fun nonMarked() = Unit

@PublicAnnotation fun markedWithPublicAnnotation() = Unit
@InternalAnnotation fun markedWithInternalAnnotation() = Unit
@PrivateAnnotation fun markedWithPrivateAnnotation() = Unit

@PublicContainer.PublicAnnotation fun markedWithPublicContainerPublicAnnotation() = Unit
@PublicContainer.InternalAnnotation fun markedWithPublicContainerInternalAnnotation() = Unit
//@PublicContainer.PrivateAnnotation fun markedWithPublicContainerPrivateAnnotation() = Unit // the annotation is inaccessible from outside PublicContainer

@InternalContainer.PublicAnnotation fun markedWithInternalContainerPublicAnnotation() = Unit
@InternalContainer.InternalAnnotation fun markedWithInternalContainerInternalAnnotation() = Unit
//@InternalContainer.PrivateAnnotation fun markedWithInternalContainerPrivateAnnotation() = Unit // the annotation is inaccessible from outside PublicContainer

@PrivateContainer.PublicAnnotation fun markedWithPrivateContainerPublicAnnotation() = Unit
@PrivateContainer.InternalAnnotation fun markedWithPrivateContainerInternalAnnotation() = Unit
//@PrivateContainer.PrivateAnnotation fun markedWithPrivateContainerPrivateAnnotation() = Unit // the annotation is inaccessible from outside PublicContainer
