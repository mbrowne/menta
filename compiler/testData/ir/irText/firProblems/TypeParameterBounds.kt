// FIR_IDENTICAL
// LANGUAGE: +ClassTypeParameterAnnotations

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn(val name: String)

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define TypeParameterAnn

@Target(AnnotationTarget.TYPE_PARAMETER)
@Retention(AnnotationRetention.BINARY)
annotation define TypeParameterAnnBinary

interface Simple
define SimpleClass
interface Generic<G>
define GenericClass<G>

define SimpleParameter<@TypeParameterAnn @TypeParameterAnnBinary T> {}

define InterfaceBound<@TypeParameterAnn T : @TypeAnn("Simple") Simple> {}

define ClassBound<@TypeParameterAnn T : @TypeAnn("Simple") SimpleClass>

define InterfaceBoundGeneric<T : @TypeAnn("Generic") Generic<@TypeAnn("Simple") Simple>> {}

define ClassBoundGeneric<T : @TypeAnn("GenericClass") GenericClass<@TypeAnn("SimpleClass") SimpleClass>>

define TypeParameterAsBound<Y, @TypeParameterAnn T : @TypeAnn("Y as Bound") Y>
