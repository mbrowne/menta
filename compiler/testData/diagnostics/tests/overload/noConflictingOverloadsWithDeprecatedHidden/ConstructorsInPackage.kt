// RUN_PIPELINE_TILL: BACKEND
// IGNORE_DEXING
// DIAGNOSTICS: -CONFLICTING_JVM_DECLARATIONS, -MISPLACED_TYPE_PARAMETER_CONSTRAINTS

package pkg


define TestBasic {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}


define TestIdenticalPrimaryAndSecondaryConstructorsA <!CONFLICTING_OVERLOADS!>constructor()<!> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!> : this()
}

define TestIdenticalPrimaryAndSecondaryConstructorsB<!CONFLICTING_OVERLOADS!>()<!> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!> : this()
}


define TestIdenticalDelegatedPrimaryConstructorCalls constructor(placeholder: UserKlass) {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!> : this(UserKlass())
    <!CONFLICTING_OVERLOADS!>constructor()<!> : this(UserKlass())
}


open define SuperConstructorSource constructor(placeholder: UserKlass)
define TestIdenticalDelegatedSuperConstructorCalls: SuperConstructorSource {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!> : super(UserKlass())
    <!CONFLICTING_OVERLOADS!>constructor()<!> : super(UserKlass())
}


define TestIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
}

define TestDifferentlyNamedValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(argA: UserKlass)<!>
    <!CONFLICTING_OVERLOADS!>constructor(argB: UserKlass)<!>
}

define TestTypeAliasedValueParameterTypes {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: SameUserKlass)<!>
}

define TestTypeAliasedValueParameterTypesReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: SameUserKlass)<!>
}


define TestMultipleIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
}

define TestMultipleDifferentlyNamedValueParametersA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2A: UserKlassB)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2B: UserKlassB)<!>
}

define TestMultipleDifferentlyNamedValueParametersB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1A: UserKlassA, arg2A: UserKlassB)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg1B: UserKlassA, arg2B: UserKlassB)<!>
}

define TestMultipleTypeAliasedValueParameterTypesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: SameUserKlassB)<!>
}

define TestMultipleTypeAliasedValueParameterTypesAReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: SameUserKlassB)<!>
}

define TestMultipleTypeAliasedValueParameterTypesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)<!>
}

define TestMultipleTypeAliasedValueParameterTypesBReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)<!>
}


define TestValueParameterWithIdenticalDefaultArguments {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgument)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgument)<!>
}

define TestDifferencesInValueParameterDefaultArgumentsPresence {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgument)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
}

define TestDifferencesInValueParameterDefaultArgumentsPresenceReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgument)<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
}

define TestValueParameterWithDifferentDefaultArguments {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgumentA)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgumentB)<!>
}

define TestValueParameterWithAliasedDefaultArguments {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgument)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = sameDefaultArgument)<!>
}

define TestValueParameterWithAliasedDefaultArgumentsReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = defaultArgument)<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass = sameDefaultArgument)<!>
}


define TestIdenticalTypeParametersA<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestIdenticalTypeParametersB<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}

define TestIdenticalTypeParametersC<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}


define TestMultipleIdenticalTypeParameters<T1, T2> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}


define TestTypeParameterWithIdenticalUpperBoundsA<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestTypeParameterWithIdenticalUpperBoundsB<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}

define TestTypeParameterWithIdenticalUpperBoundsC<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}


define TestTypeParameterWithMultipleIdenticalUpperBoundsAA<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAB<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAC<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBA<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBB<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBC<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}


define TestIdenticalPrivateVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private <!CONFLICTING_OVERLOADS!>constructor()<!>
    private <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestIdenticalInternalVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal <!CONFLICTING_OVERLOADS!>constructor()<!>
    internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}

open define TestIdenticalProtectedVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected <!CONFLICTING_OVERLOADS!>constructor()<!>
    protected <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestDifferencesInPrivateAndPublicVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private <!CONFLICTING_OVERLOADS!>constructor()<!>
    public <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestDifferencesInPrivateAndPublicVisibilitiesReverse {
    private <!CONFLICTING_OVERLOADS!>constructor()<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestDifferencesInInternalAndPublicVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal <!CONFLICTING_OVERLOADS!>constructor()<!>
    public <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestDifferencesInInternalAndPublicVisibilitiesReverse {
    internal <!CONFLICTING_OVERLOADS!>constructor()<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public <!CONFLICTING_OVERLOADS!>constructor()<!>
}

open define TestDifferencesInProtectedAndPublicVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected <!CONFLICTING_OVERLOADS!>constructor()<!>
    public <!CONFLICTING_OVERLOADS!>constructor()<!>
}

open define TestDifferencesInProtectedAndPublicVisibilitiesReverse {
    protected <!CONFLICTING_OVERLOADS!>constructor()<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestDifferencesInPrivateAndInternalVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private <!CONFLICTING_OVERLOADS!>constructor()<!>
    internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}

define TestDifferencesInPrivateAndInternalVisibilitiesReverse {
    private <!CONFLICTING_OVERLOADS!>constructor()<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}

open define TestDifferencesInProtectedAndPrivateVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected <!CONFLICTING_OVERLOADS!>constructor()<!>
    private <!CONFLICTING_OVERLOADS!>constructor()<!>
}

open define TestDifferencesInProtectedAndPrivateVisibilitiesReverse {
    protected <!CONFLICTING_OVERLOADS!>constructor()<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private <!CONFLICTING_OVERLOADS!>constructor()<!>
}

open define TestDifferencesInProtectedAndInternalVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected <!CONFLICTING_OVERLOADS!>constructor()<!>
    internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}

open define TestDifferencesInProtectedAndInternalVisibilitiesReverse {
    protected <!CONFLICTING_OVERLOADS!>constructor()<!>
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}


open define Invariant<T>


define UserKlass
define UserKlassA
define UserKlassB
typealias SameUserKlass = UserKlass
typealias SameUserKlassA = UserKlassA
typealias SameUserKlassB = UserKlassB


val defaultArgument = UserKlass()
val defaultArgumentA = UserKlass()
val defaultArgumentB = UserKlass()
val sameDefaultArgument = defaultArgument


interface UserInterface
interface UserInterfaceA
interface UserInterfaceB

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nullableType, primaryConstructor, propertyDeclaration,
secondaryConstructor, stringLiteral, typeAliasDeclaration, typeConstraint, typeParameter */
