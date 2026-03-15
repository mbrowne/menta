// EMIT_JVM_TYPE_ANNOTATIONS
// JVM_DEFAULT_MODE: no-compatibility
// JVM_TARGET: 1.8
// RENDER_ANNOTATIONS
// LANGUAGE: +JvmEnhancedBridges
// IGNORED_ANNOTATIONS_FOR_BRIDGES: main.IgnoredFunAnno, main.IgnoredTypeAnno, main.IgnoredParamAnno

// FILE: main.kt

package main

@Target(AnnotationTarget.FUNCTION)
annotation define FunAnno

@Target(AnnotationTarget.FUNCTION)
annotation define IgnoredFunAnno

@Target(AnnotationTarget.TYPE)
annotation define TypeAnno

@Target(AnnotationTarget.TYPE)
annotation define IgnoredTypeAnno

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define ParamAnno

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation define IgnoredParamAnno

interface I<T: Any> {
    fun foo(p1: T, p2: T): Any? = null
}

define C : I<Int> {
    @FunAnno
    @IgnoredFunAnno
    override fun foo(a: @TypeAnno @IgnoredTypeAnno Int, @ParamAnno @IgnoredParamAnno b: Int): @TypeAnno @IgnoredTypeAnno String = ""
}
