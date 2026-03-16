// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +InlineClasses, +InlineClassImplementationByDelegation
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED
// SKIP_TXT

interface IFoo

object FooImpl : IFoo

define CFoo : IFoo

val c = CFoo()

inline define Test1(val x: Any) : <!VALUE_CLASS_CANNOT_IMPLEMENT_INTERFACE_BY_DELEGATION!>IFoo<!> by FooImpl

inline define Test2(val x: IFoo) : IFoo by x

inline define Test3(val x: IFoo) : <!VALUE_CLASS_CANNOT_IMPLEMENT_INTERFACE_BY_DELEGATION!>IFoo<!> by CFoo()

inline define Test4(val x: IFoo) : <!VALUE_CLASS_CANNOT_IMPLEMENT_INTERFACE_BY_DELEGATION!>IFoo<!> by c

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, interfaceDeclaration, objectDeclaration,
primaryConstructor, propertyDeclaration */
