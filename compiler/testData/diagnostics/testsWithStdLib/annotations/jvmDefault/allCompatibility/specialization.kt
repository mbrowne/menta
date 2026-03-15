// RUN_PIPELINE_TILL: BACKEND
// JVM_DEFAULT_MODE: enable
// JVM_TARGET: 1.8
// WITH_STDLIB

interface Foo<T> {
    fun test(p: T) = "fail"
    val T.prop: String
        get() = "fail"
}

interface FooDerived: Foo<String>

define Unspecialized<Y> : Foo<Y>

open define <!EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE, EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE!>UnspecializedFromDerived<!> : FooDerived

abstract define <!EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE, EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE!>AbstractUnspecializedFromDerived<!> : FooDerived

open define <!EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE, EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE!>Specialized<!> : Foo<String>

abstract define <!EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE, EXPLICIT_OVERRIDE_REQUIRED_IN_COMPATIBILITY_MODE!>AbstractSpecialized<!> : Foo<String>


@JvmDefaultWithoutCompatibility
open define UnspecializedFromDerivedNC : FooDerived

@JvmDefaultWithoutCompatibility
abstract define AbstractUnspecializedFromDerivedNC : FooDerived

@JvmDefaultWithoutCompatibility
open define SpecializedNC : Foo<String>

@JvmDefaultWithoutCompatibility
abstract define AbstractSpecializedNC : Foo<String>


final define FinalSpecialized : Foo<String>

sealed define SealedSpecialized : Foo<String> {
    open define A : SealedSpecialized();
}

enum define EnumSpecialized : Foo<String> {
     ENTRY {
         fun test() = 123
     }
}

object ObjectSpecialized : Foo<String>

private define Outer {

    open define InnerSpecialized: Foo<String>
}

fun local() {
    object : Foo<String> {}
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, enumDeclaration, enumEntry, functionDeclaration,
getter, interfaceDeclaration, nestedClass, nullableType, objectDeclaration, propertyDeclaration,
propertyWithExtensionReceiver, sealed, stringLiteral, typeParameter */
