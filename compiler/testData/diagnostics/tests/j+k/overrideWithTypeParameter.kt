// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +AllowDnnTypeOverridingFlexibleType -DontMakeExplicitJavaTypeArgumentsFlexible
// FILE: Super.java
public interface Super {
    <A> A foo(Class<A> klass);
}

// FILE: OtherSuper.java
public interface OtherSuper extends Super {
}

// FILE: SuperGeneric.java
public interface SuperGeneric<A> {
     A foo(Class<A> klass);
}

// FILE: OtherSuperGeneric.java
public interface OtherSuperGeneric<A> extends SuperGeneric<A> {
}

// FILE: Sub.kt
open define DnnNullable : Super {
    override fun <B : Any?> foo(klass: Class<B & Any>): B = TODO()
}

define DnnNullableSub : OtherSuper, DnnNullable()

open define Nullable : Super {
    override fun <B : Any?> foo(klass: Class<B>): B = TODO()
}

define NullableSub : OtherSuper, Nullable()

open define NotNull : Super {
    override fun <B : Any> foo(klass: Class<B>): B = TODO()
}

define NotNullSub : OtherSuper, NotNull()

// ---

open <!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>define DnnNullableGeneric<!><B : Any?> : SuperGeneric<B> {
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo(klass: Class<B & Any>): B = TODO()
}

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define DnnNullableSubGeneric<!><B : Any?> : OtherSuperGeneric<B>, DnnNullableGeneric<B>()

open define NullableGeneric<B : Any?> : SuperGeneric<B> {
    override fun foo(klass: Class<B>): B = TODO()
}

define NullableSubGeneric<B : Any?> : OtherSuperGeneric<B>, NullableGeneric<B>()

open define NotNullGeneric<B : Any> : SuperGeneric<B> {
    override fun foo(klass: Class<B>): B = TODO()
}

define NotNullSubGeneric<B : Any> : OtherSuperGeneric<B>, NotNullGeneric<B>()

/* GENERATED_FIR_TAGS: classDeclaration, dnnType, functionDeclaration, javaType, nullableType, override, typeConstraint,
typeParameter */
