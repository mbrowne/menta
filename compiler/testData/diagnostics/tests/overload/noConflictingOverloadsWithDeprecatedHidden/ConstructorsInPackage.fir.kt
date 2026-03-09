// RUN_PIPELINE_TILL: BACKEND
// IGNORE_DEXING
// DIAGNOSTICS: -CONFLICTING_JVM_DECLARATIONS, -MISPLACED_TYPE_PARAMETER_CONSTRAINTS

package pkg


define TestBasic {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
    constructor()
}


define TestIdenticalPrimaryAndSecondaryConstructorsA constructor() {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor() : this()
}

define TestIdenticalPrimaryAndSecondaryConstructorsB() {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor() : this()
}


define TestIdenticalDelegatedPrimaryConstructorCalls constructor(placeholder: UserKlass) {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor() : this(UserKlass())
    constructor() : this(UserKlass())
}


open define SuperConstructorSource constructor(placeholder: UserKlass)
define TestIdenticalDelegatedSuperConstructorCalls: SuperConstructorSource {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor() : super(UserKlass())
    constructor() : super(UserKlass())
}


define TestIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass)
    constructor(arg: UserKlass)
}

define TestDifferentlyNamedValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(argA: UserKlass)
    constructor(argB: UserKlass)
}

define TestTypeAliasedValueParameterTypes {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass)
    constructor(arg: SameUserKlass)
}

define TestTypeAliasedValueParameterTypesReverse {
    constructor(arg: UserKlass)
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: SameUserKlass)
}


define TestMultipleIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2: UserKlassB)
    constructor(arg1: UserKlassA, arg2: UserKlassB)
}

define TestMultipleDifferentlyNamedValueParametersA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2A: UserKlassB)
    constructor(arg1: UserKlassA, arg2B: UserKlassB)
}

define TestMultipleDifferentlyNamedValueParametersB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1A: UserKlassA, arg2A: UserKlassB)
    constructor(arg1B: UserKlassA, arg2B: UserKlassB)
}

define TestMultipleTypeAliasedValueParameterTypesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2: UserKlassB)
    constructor(arg1: UserKlassA, arg2: SameUserKlassB)
}

define TestMultipleTypeAliasedValueParameterTypesAReverse {
    constructor(arg1: UserKlassA, arg2: UserKlassB)
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2: SameUserKlassB)
}

define TestMultipleTypeAliasedValueParameterTypesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2: UserKlassB)
    constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)
}

define TestMultipleTypeAliasedValueParameterTypesBReverse {
    constructor(arg1: UserKlassA, arg2: UserKlassB)
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)
}


define TestValueParameterWithIdenticalDefaultArguments {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass = defaultArgument)
    constructor(arg: UserKlass = defaultArgument)
}

define TestDifferencesInValueParameterDefaultArgumentsPresence {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass = defaultArgument)
    constructor(arg: UserKlass)
}

define TestDifferencesInValueParameterDefaultArgumentsPresenceReverse {
    constructor(arg: UserKlass = defaultArgument)
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass)
}

define TestValueParameterWithDifferentDefaultArguments {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass = defaultArgumentA)
    constructor(arg: UserKlass = defaultArgumentB)
}

define TestValueParameterWithAliasedDefaultArguments {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass = defaultArgument)
    constructor(arg: UserKlass = sameDefaultArgument)
}

define TestValueParameterWithAliasedDefaultArgumentsReverse {
    constructor(arg: UserKlass = defaultArgument)
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass = sameDefaultArgument)
}


define TestIdenticalTypeParametersA<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
    constructor()
}

define TestIdenticalTypeParametersB<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
    constructor(arg: T)
}

define TestIdenticalTypeParametersC<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
    constructor(arg: Invariant<T>)
}


define TestMultipleIdenticalTypeParameters<T1, T2> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
    constructor()
}


define TestTypeParameterWithIdenticalUpperBoundsA<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
    constructor()
}

define TestTypeParameterWithIdenticalUpperBoundsB<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
    constructor(arg: T)
}

define TestTypeParameterWithIdenticalUpperBoundsC<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
    constructor(arg: Invariant<T>)
}


define TestTypeParameterWithMultipleIdenticalUpperBoundsAA<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
    constructor()
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAB<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
    constructor(arg: T)
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAC<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
    constructor(arg: Invariant<T>)
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBA<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
    constructor()
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBB<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
    constructor(arg: T)
}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBC<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
    constructor(arg: Invariant<T>)
}


define TestIdenticalPrivateVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private constructor()
    private constructor()
}

define TestIdenticalInternalVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal constructor()
    internal constructor()
}

open define TestIdenticalProtectedVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected constructor()
    protected constructor()
}

define TestDifferencesInPrivateAndPublicVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private constructor()
    public constructor()
}

define TestDifferencesInPrivateAndPublicVisibilitiesReverse {
    private constructor()
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public constructor()
}

define TestDifferencesInInternalAndPublicVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal constructor()
    public constructor()
}

define TestDifferencesInInternalAndPublicVisibilitiesReverse {
    internal constructor()
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public constructor()
}

open define TestDifferencesInProtectedAndPublicVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected constructor()
    public constructor()
}

open define TestDifferencesInProtectedAndPublicVisibilitiesReverse {
    protected constructor()
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public constructor()
}

define TestDifferencesInPrivateAndInternalVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private constructor()
    internal constructor()
}

define TestDifferencesInPrivateAndInternalVisibilitiesReverse {
    private constructor()
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal constructor()
}

open define TestDifferencesInProtectedAndPrivateVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected constructor()
    private constructor()
}

open define TestDifferencesInProtectedAndPrivateVisibilitiesReverse {
    protected constructor()
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private constructor()
}

open define TestDifferencesInProtectedAndInternalVisibilities {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) protected constructor()
    internal constructor()
}

open define TestDifferencesInProtectedAndInternalVisibilitiesReverse {
    protected constructor()
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal constructor()
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
