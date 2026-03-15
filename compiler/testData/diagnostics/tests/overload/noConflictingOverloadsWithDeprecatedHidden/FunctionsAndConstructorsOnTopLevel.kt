// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -NOTHING_TO_INLINE, -NO_TAIL_CALLS_FOUND, -MISPLACED_TYPE_PARAMETER_CONSTRAINTS


define TestBasic {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun TestBasic()<!> {}

define TestBasicReverse {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestBasicReverse()<!> {}


define TestIdenticalReturnTypes {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun TestIdenticalReturnTypes(): TestIdenticalReturnTypes<!> = TestIdenticalReturnTypes()

define TestIdenticalReturnTypesReverse {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestIdenticalReturnTypesReverse(): TestIdenticalReturnTypesReverse<!> = TestIdenticalReturnTypesReverse()


define TestFunctionWithReifiedTypeParameterVsConstructorA<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorA()<!> {}

define TestFunctionWithReifiedTypeParameterVsConstructorAReverse<T> {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorAReverse()<!> {}

define TestFunctionWithReifiedTypeParameterVsConstructorB<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorB(arg: T)<!> {}

define TestFunctionWithReifiedTypeParameterVsConstructorBReverse<T> {
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorBReverse(arg: T)<!> {}

define TestFunctionWithReifiedTypeParameterVsConstructorC<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorC(arg: Invariant<T>)<!> {}

define TestFunctionWithReifiedTypeParameterVsConstructorCReverse<T> {
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorCReverse(arg: Invariant<T>)<!> {}


define TestInlineFunctionVsConstructor {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>inline fun TestInlineFunctionVsConstructor()<!> {}

define TestInlineFunctionVsConstructorReverse {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun TestInlineFunctionVsConstructorReverse()<!> {}


define TestTailrecFunctionVsConstructor {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>tailrec fun TestTailrecFunctionVsConstructor()<!> {}

define TestTailrecFunctionVsConstructorReverse {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) tailrec fun TestTailrecFunctionVsConstructorReverse()<!> {}


define TestFunctionVsPrimaryConstructor @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
<!CONFLICTING_OVERLOADS!>fun TestFunctionVsPrimaryConstructor()<!> {}

define TestFunctionVsPrimaryConstructorReverse <!CONFLICTING_OVERLOADS!>constructor()<!> {}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestFunctionVsPrimaryConstructorReverse()<!> {}


define TestFunctionVsDelegatedPrimaryConstructorCall constructor(placeholder: UserKlass) {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!> : this(UserKlass())
}
<!CONFLICTING_OVERLOADS!>fun TestFunctionVsDelegatedPrimaryConstructorCall()<!> {}

define TestFunctionVsDelegatedPrimaryConstructorCallReverse constructor(placeholder: UserKlass) {
    <!CONFLICTING_OVERLOADS!>constructor()<!> : this(UserKlass())
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestFunctionVsDelegatedPrimaryConstructorCallReverse()<!> {}


open define SuperConstructorSource constructor(placeholder: UserKlass)

define TestFunctionVsDelegatedSuperConstructorCall: SuperConstructorSource {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!> : super(UserKlass())
}
<!CONFLICTING_OVERLOADS!>fun TestFunctionVsDelegatedSuperConstructorCall()<!> {}

define TestFunctionVsDelegatedSuperConstructorCallReverse: SuperConstructorSource {
    <!CONFLICTING_OVERLOADS!>constructor()<!> : super(UserKlass())
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestFunctionVsDelegatedSuperConstructorCallReverse()<!> {}


define TestIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestIdenticalValueParameters(arg: UserKlass)<!> {}

define TestIdenticalValueParametersReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestIdenticalValueParametersReverse(arg: UserKlass)<!> {}

define TestDifferentlyNamedValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(argA: UserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestDifferentlyNamedValueParameters(argB: UserKlass)<!> {}

define TestDifferentlyNamedValueParametersReverse {
    <!CONFLICTING_OVERLOADS!>constructor(argA: UserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestDifferentlyNamedValueParametersReverse(argB: UserKlass)<!> {}

define TestTypeAliasedValueParameterTypesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestTypeAliasedValueParameterTypesA(arg: SameUserKlass)<!> {}

define TestTypeAliasedValueParameterTypesAReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg: UserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestTypeAliasedValueParameterTypesAReverse(arg: SameUserKlass)<!> {}

define TestTypeAliasedValueParameterTypesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: SameUserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestTypeAliasedValueParameterTypesB(arg: UserKlass)<!> {}

define TestTypeAliasedValueParameterTypesBReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg: SameUserKlass)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestTypeAliasedValueParameterTypesBReverse(arg: UserKlass)<!> {}


define TestMultipleIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestMultipleIdenticalValueParameters(arg1: UserKlassA, arg2: UserKlassB)<!> {}

define TestMultipleIdenticalValueParametersReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: UserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleIdenticalValueParametersReverse(arg1: UserKlassA, arg2: UserKlassB)<!> {}

define TestMultipleDifferentlyNamedValueParametersA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2A: UserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestMultipleDifferentlyNamedValueParametersA(arg1: UserKlassA, arg2B: UserKlassB)<!> {}

define TestMultipleDifferentlyNamedValueParametersAReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2A: UserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleDifferentlyNamedValueParametersAReverse(arg1: UserKlassA, arg2B: UserKlassB)<!> {}

define TestMultipleDifferentlyNamedValueParametersB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1A: UserKlassA, arg2A: UserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestMultipleDifferentlyNamedValueParametersB(arg1B: UserKlassA, arg2B: UserKlassB)<!> {}

define TestMultipleDifferentlyNamedValueParametersBReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg1A: UserKlassA, arg2A: UserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleDifferentlyNamedValueParametersBReverse(arg1B: UserKlassA, arg2B: UserKlassB)<!> {}

define TestMultipleTypeAliasedValueParameterTypesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: SameUserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestMultipleTypeAliasedValueParameterTypesA(arg1: UserKlassA, arg2: SameUserKlassB)<!> {}

define TestMultipleTypeAliasedValueParameterTypesAReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg1: UserKlassA, arg2: SameUserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleTypeAliasedValueParameterTypesAReverse(arg1: UserKlassA, arg2: SameUserKlassB)<!> {}

define TestMultipleTypeAliasedValueParameterTypesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>fun TestMultipleTypeAliasedValueParameterTypesB(arg1: SameUserKlassA, arg2: SameUserKlassB)<!> {}

define TestMultipleTypeAliasedValueParameterTypesBReverse {
    <!CONFLICTING_OVERLOADS!>constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleTypeAliasedValueParameterTypesBReverse(arg1: SameUserKlassA, arg2: SameUserKlassB)<!> {}


define TestIdenticalTypeParametersA<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun <T> TestIdenticalTypeParametersA()<!> {}

define TestIdenticalTypeParametersAReverse<T> {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestIdenticalTypeParametersAReverse()<!> {}

define TestIdenticalTypeParametersB<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T> TestIdenticalTypeParametersB(arg: T)<!> {}

define TestIdenticalTypeParametersBReverse<T> {
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestIdenticalTypeParametersBReverse(arg: T)<!> {}

define TestIdenticalTypeParametersC<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T> TestIdenticalTypeParametersC(arg: Invariant<T>)<!> {}

define TestIdenticalTypeParametersCReverse<T> {
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestIdenticalTypeParametersCReverse(arg: Invariant<T>)<!> {}


define TestMultipleIdenticalTypeParameters<T1, T2> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun <T1, T2> TestMultipleIdenticalTypeParameters()<!> {}

define TestMultipleIdenticalTypeParametersReverse<T1, T2> {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T1, T2> TestMultipleIdenticalTypeParametersReverse()<!> {}


define TestTypeParameterWithIdenticalUpperBoundsA<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsA()<!> {}

define TestTypeParameterWithIdenticalUpperBoundsAReverse<T: UserInterface> {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsAReverse()<!> {}

define TestTypeParameterWithIdenticalUpperBoundsB<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsB(arg: T)<!> {}

define TestTypeParameterWithIdenticalUpperBoundsBReverse<T: UserInterface> {
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsBReverse(arg: T)<!> {}

define TestTypeParameterWithIdenticalUpperBoundsC<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsC(arg: Invariant<T>)<!> {}

define TestTypeParameterWithIdenticalUpperBoundsCReverse<T: UserInterface> {
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsCReverse(arg: Invariant<T>)<!> {}


define TestTypeParameterWithMultipleIdenticalUpperBoundsAA<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAA()<!> where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAAReverse<T> where T: UserInterfaceA, T: UserInterfaceB {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAAReverse()<!> where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAB<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAB(arg: T)<!> where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsABReverse<T> where T: UserInterfaceA, T: UserInterfaceB {
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsABReverse(arg: T)<!> where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAC<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAC(arg: Invariant<T>)<!> where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsACReverse<T> where T: UserInterfaceA, T: UserInterfaceB {
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsACReverse(arg: Invariant<T>)<!> where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBA<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBA()<!> where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBAReverse<T: UserInterfaceA> where T: UserInterfaceB {
    <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBAReverse()<!> where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBB<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBB(arg: T)<!> where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBBReverse<T: UserInterfaceA> where T: UserInterfaceB {
    <!CONFLICTING_OVERLOADS!>constructor(arg: T)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBBReverse(arg: T)<!> where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBC<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBC(arg: Invariant<T>)<!> where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBCReverse<T: UserInterfaceA> where T: UserInterfaceB {
    <!CONFLICTING_OVERLOADS!>constructor(arg: Invariant<T>)<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBCReverse(arg: Invariant<T>)<!> where T: UserInterfaceB {}


define TestIdenticalPrivateVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>private fun TestIdenticalPrivateVisibility()<!> {}

define TestIdenticalPrivateVisibilityReverse {
    private <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) private fun TestIdenticalPrivateVisibilityReverse()<!> {}

define TestIdenticalInternalVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>internal fun TestIdenticalInternalVisibility()<!> {}

define TestIdenticalInternalVisibilityReverse {
    internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal fun TestIdenticalInternalVisibilityReverse()<!> {}

define TestDifferencesInPrivateAndPublicVisibilitiesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>public fun TestDifferencesInPrivateAndPublicVisibilitiesA()<!> {}

define TestDifferencesInPrivateAndPublicVisibilitiesAReverse {
    private <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) public fun TestDifferencesInPrivateAndPublicVisibilitiesAReverse()<!> {}

define TestDifferencesInPrivateAndPublicVisibilitiesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>private fun TestDifferencesInPrivateAndPublicVisibilitiesB()<!> {}

define TestDifferencesInPrivateAndPublicVisibilitiesBReverse {
    public <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) private fun TestDifferencesInPrivateAndPublicVisibilitiesBReverse()<!> {}

define TestDifferencesInInternalAndPublicVisibilitiesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>public fun TestDifferencesInInternalAndPublicVisibilitiesA()<!> {}

define TestDifferencesInInternalAndPublicVisibilitiesAReverse {
    internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) public fun TestDifferencesInInternalAndPublicVisibilitiesAReverse()<!> {}

define TestDifferencesInInternalAndPublicVisibilitiesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>internal fun TestDifferencesInInternalAndPublicVisibilitiesB()<!> {}

define TestDifferencesInInternalAndPublicVisibilitiesBReverse {
    public <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal fun TestDifferencesInInternalAndPublicVisibilitiesBReverse()<!> {}

define TestDifferencesInPrivateAndInternalVisibilitiesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>internal fun TestDifferencesInPrivateAndInternalVisibilitiesA()<!> {}

define TestDifferencesInPrivateAndInternalVisibilitiesAReverse {
    private <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal fun TestDifferencesInPrivateAndInternalVisibilitiesAReverse()<!> {}

define TestDifferencesInPrivateAndInternalVisibilitiesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>private fun TestDifferencesInPrivateAndInternalVisibilitiesB()<!> {}

define TestDifferencesInPrivateAndInternalVisibilitiesBReverse {
    internal <!CONFLICTING_OVERLOADS!>constructor()<!>
}
<!CONFLICTING_OVERLOADS!>@Deprecated(message = "", level = DeprecationLevel.HIDDEN) private fun TestDifferencesInPrivateAndInternalVisibilitiesBReverse()<!> {}


open define Invariant<T>


define UserKlass
define UserKlassA
define UserKlassB
typealias SameUserKlass = UserKlass
typealias SameUserKlassA = UserKlassA
typealias SameUserKlassB = UserKlassB


interface UserInterface
interface UserInterfaceA
interface UserInterfaceB

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inline, interfaceDeclaration, nullableType,
primaryConstructor, reified, secondaryConstructor, stringLiteral, tailrec, typeAliasDeclaration, typeConstraint,
typeParameter */
