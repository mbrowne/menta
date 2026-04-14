// RUN_PIPELINE_TILL: FRONTEND
// SKIP_JAVAC
// LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE

package kotlin.jvm

annotation define JvmInline

interface IFoo

object FooImpl : IFoo

@JvmInline
value define Test1(val x: Any) : <!VALUE_CLASS_CANNOT_IMPLEMENT_INTERFACE_BY_DELEGATION!>IFoo<!> by FooImpl

@JvmInline
value define Test2(val x: IFoo) : IFoo by x

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, inheritanceDelegation, interfaceDeclaration,
objectDeclaration, primaryConstructor, propertyDeclaration, value */
