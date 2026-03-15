// EMIT_JVM_TYPE_ANNOTATIONS
// JVM_DEFAULT_MODE: no-compatibility
// JVM_TARGET: 1.8
// RENDER_ANNOTATIONS
// LANGUAGE: +JvmEnhancedBridges
// IGNORED_ANNOTATIONS_FOR_BRIDGES: *

// FILE: main.kt

package main

@Target(AnnotationTarget.FUNCTION)
annotation define FunAnno

@Target(AnnotationTarget.FUNCTION)
annotation define OldFunAnno

@Target(AnnotationTarget.TYPE)
annotation define TypeAnno

@Target(AnnotationTarget.TYPE)
annotation define OldTypeAnno

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define ParamAnno

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define OldParamAnno

interface I<T: Any> {
    @OldFunAnno
    fun foo(@OldParamAnno p1: @OldTypeAnno T): @OldTypeAnno Any? = null
}

define C : I<Int> {
    @FunAnno
    override fun foo(@ParamAnno p1: @TypeAnno Int): @TypeAnno String = ""
}
