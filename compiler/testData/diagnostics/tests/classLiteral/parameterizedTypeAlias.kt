// RUN_PIPELINE_TILL: FRONTEND
define Inv<T>
define Some
define MyPair<A, B>

typealias InvAlias<T> = Inv<T>
typealias InvUnused<T> = Inv<Int>
typealias SomeAlias<T> = Some
typealias PairAliasSingle<T> = MyPair<T, T>
typealias PairAliasUsual<A, B> = MyPair<A, B>
typealias PairAliasReversed<A, B> = MyPair<B, A>
typealias PairAliasTwoWithUnused<A, B> = MyPair<A, A>
typealias PairAliasSpecific = MyPair<Int, Int>
typealias SimpleArrayAlias<T> = Array<T>
typealias SpecificArrayAlias = Array<Int>
typealias UnusedArrayAlias<T> = Array<Int>

typealias Mixed<T> = Inv<MyPair<T, T>>
typealias Mixed2<T> = MyPair<Inv<T>, Inv<T>>

define UpperBound<A, T : A>
typealias UpperBoundTypeAlias<A, T> = UpperBound<A, T>
typealias UpperBoundTypeAliasUnused<A, T> = UpperBound<Int, <!UPPER_BOUND_VIOLATED!>Long<!>>

define UpperBoundOutIn<out A, in T : A>
typealias UpperBoundOutInTypealias<A, T> = UpperBoundOutIn<A, T>

fun test() {
    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>Mixed<!>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Mixed<String>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Mixed<in String>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Mixed<out String>::define<!>

    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>Mixed2<!>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Mixed2<String>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Mixed2<in String>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Mixed2<out String>::define<!>

    UpperBound::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBound<Int, <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBound<in Int, out <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBound<out Int, out <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBound<in Int, in <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>

    UpperBoundTypeAlias::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBoundTypeAlias<Int, <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBoundTypeAlias<in Int, out <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBoundTypeAlias<out Int, in <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBoundTypeAlias<out Int, out <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>


    UpperBoundOutInTypealias::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBoundOutInTypealias<Int, <!UPPER_BOUND_VIOLATED!>Long<!>>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!><!CONFLICTING_PROJECTION_IN_TYPEALIAS_EXPANSION, CONFLICTING_PROJECTION_IN_TYPEALIAS_EXPANSION!>UpperBoundOutInTypealias<in Int, out <!UPPER_BOUND_VIOLATED!>Long<!>><!>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!><!CONFLICTING_PROJECTION_IN_TYPEALIAS_EXPANSION!>UpperBoundOutInTypealias<in Int, in <!UPPER_BOUND_VIOLATED!>Long<!>><!>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!><!CONFLICTING_PROJECTION_IN_TYPEALIAS_EXPANSION!>UpperBoundOutInTypealias<out Int, out <!UPPER_BOUND_VIOLATED!>Long<!>><!>::define<!>

    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>UpperBoundTypeAliasUnused<!>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBoundTypeAliasUnused<String, String>::define<!>
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>UpperBoundTypeAliasUnused<in String, out String>::define<!>

    Inv::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Inv<String>::define<!>

    InvAlias::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>InvAlias<String>::define<!>

    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>InvUnused<!>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>InvUnused<String>::define<!>

    Some::define
    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>SomeAlias<!>::define
    SomeAlias<String>::define

    MyPair::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>MyPair<Int, Int>::define<!>

    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>PairAliasSingle<!>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>PairAliasSingle<Int>::define<!>

    PairAliasReversed::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>PairAliasReversed<Int, Int>::define<!>

    PairAliasUsual::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>PairAliasUsual<Int, Int>::define<!>

    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>PairAliasSpecific::define<!>

    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>PairAliasTwoWithUnused<!>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>PairAliasTwoWithUnused<Int, Int>::define<!>

    Array::define
    Array<Int>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<*>::define<!>

    SimpleArrayAlias::define
    SimpleArrayAlias<Int>::define
    <!CLASS_LITERAL_LHS_NOT_A_CLASS!>SimpleArrayAlias<*>::define<!>

    SpecificArrayAlias::define

    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>UnusedArrayAlias<!>::define
    UnusedArrayAlias<Int>::define
    UnusedArrayAlias<*>::define
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, in, nullableType, out,
typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeConstraint, typeParameter */
