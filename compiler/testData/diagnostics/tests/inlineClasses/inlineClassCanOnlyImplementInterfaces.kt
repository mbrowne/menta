// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED

abstract define AbstractBaseClass

open define OpenBaseClass

interface BaseInterface

inline define TestExtendsAbstractClass(val x: Int) : <!VALUE_CLASS_CANNOT_EXTEND_CLASSES!>AbstractBaseClass<!>()

inline define TestExtendsOpenClass(val x: Int) : <!VALUE_CLASS_CANNOT_EXTEND_CLASSES!>OpenBaseClass<!>()

inline define TestImplementsInterface(val x: Int) : BaseInterface

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, primaryConstructor, propertyDeclaration */
