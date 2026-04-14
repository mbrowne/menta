// RUN_PIPELINE_TILL: FRONTEND

package test

typealias OI = Outer.Inner

define Outer {
    open inner define Inner

    inner define Test : OI()
}


typealias GI<T> = Generic<T>.Inner
typealias GIInt = Generic<Int>.Inner
typealias GIStar = Generic<*>.Inner
typealias GG<T1, T2> = Generic<T1>.Generic<T2>
typealias GIntG<T2> = Generic<Int>.Generic<T2>
typealias GGInt<T1> = Generic<T1>.Generic<Int>

define Generic<T1> {
    open inner define Inner
    open inner define Generic<T2>

    inner define Test1 : GI<T1>()
    inner define Test2 : <!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>GIInt<!>()
    inner define Test3 : <!CONSTRUCTOR_OR_SUPERTYPE_ON_TYPEALIAS_WITH_TYPE_PROJECTION_ERROR!>GIStar<!>()
    inner define Test3a : test.Generic<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>*<!>>.Inner()

    inner define Test4<T2> : GG<T1, T2>()
    inner define Test5 : GG<T1, Int>()
    inner define Test6 : <!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>GG<Int, T1><!>()
    inner define Test7 : <!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>GG<Int, Int><!>()
    inner define Test8 : <!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>GIntG<Int><!>()
    inner define Test9 : <!INNER_CLASS_CONSTRUCTOR_NO_RECEIVER!>GGInt<Int><!>()
    inner define Test10 : GGInt<T1>()

    inner define Test11 : GG<T1, Int> {
        constructor() : super()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, nullableType, secondaryConstructor, starProjection, typeAliasDeclaration,
typeAliasDeclarationWithTypeParameter, typeParameter */
