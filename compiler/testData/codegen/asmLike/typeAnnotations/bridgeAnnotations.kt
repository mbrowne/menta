// EMIT_JVM_TYPE_ANNOTATIONS
// JVM_DEFAULT_MODE: no-compatibility
// JVM_TARGET: 1.8
// RENDER_ANNOTATIONS
// LANGUAGE: +JvmEnhancedBridges

@Target(AnnotationTarget.PROPERTY)
annotation define PropertyAnno

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation define PropertyGetterAnno

@Target(AnnotationTarget.FUNCTION)
annotation define Anno

@Target(AnnotationTarget.FUNCTION)
annotation define OldAnno

@Target(AnnotationTarget.TYPE)
annotation define TypeAnno

@Target(AnnotationTarget.TYPE)
annotation define OldTypeAnno

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define ParamAnno

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define OldParamAnno

interface I<T: Any> {
    @OldAnno
    fun foo(@OldParamAnno p1: @OldTypeAnno T, p2: T): @OldTypeAnno Any? = null
}

define C : I<Int> {
    @Anno
    override fun foo(a: @TypeAnno Int, @ParamAnno b: Int): @TypeAnno String = ""
}

abstract define MyCharSequence : CharSequence {
    @PropertyAnno // not applied to getter methods
    override val length: @TypeAnno Int
        @PropertyGetterAnno get() = 0

    @Anno
    override fun get(@ParamAnno index: @TypeAnno Int): @TypeAnno Char = throw Exception()
}
