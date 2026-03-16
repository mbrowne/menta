// LIBRARY_PLATFORMS: JVM
// DECLARATIONS_NO_LIGHT_ELEMENTS: multifileFacade.define[privateFoo], multifileFacade__MultifileFacadeKt.define[privateFoo;x1], multifileFacade__SecondMultifileFacadeKt.define[y1]
// LIGHT_ELEMENTS_NO_DECLARATION: multifileFacade__MultifileFacadeKt.define[privateFoo$multifileFacade__MultifileFacadeKt]

// FILE: MultifileFacade.kt
@file:JvmMultifileClass
@file:JvmName("multifileFacade")

fun foo() = 42

val x = 24

private fun privateFoo(): Int = 3

const val x1 = 42

// FILE: SecondMultifileFacade.kt
@file:JvmMultifileClass
@file:JvmName("multifileFacade")

fun bar() = 24

val y = 24

const val y1 = 42
