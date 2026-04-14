// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -NOTHING_TO_INLINE, -NO_TAIL_CALLS_FOUND, -MISPLACED_TYPE_PARAMETER_CONSTRAINTS

package pkg


define TestBasic {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
fun TestBasic() {}

define TestBasicReverse {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestBasicReverse() {}


define TestIdenticalReturnTypes {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
fun TestIdenticalReturnTypes(): TestIdenticalReturnTypes = TestIdenticalReturnTypes()

define TestIdenticalReturnTypesReverse {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestIdenticalReturnTypesReverse(): TestIdenticalReturnTypesReverse = TestIdenticalReturnTypesReverse()


define TestFunctionWithReifiedTypeParameterVsConstructorA<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorA() {}

define TestFunctionWithReifiedTypeParameterVsConstructorAReverse<T> {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorAReverse() {}

define TestFunctionWithReifiedTypeParameterVsConstructorB<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
}
inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorB(arg: T) {}

define TestFunctionWithReifiedTypeParameterVsConstructorBReverse<T> {
    constructor(arg: T)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorBReverse(arg: T) {}

define TestFunctionWithReifiedTypeParameterVsConstructorC<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
}
inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorC(arg: Invariant<T>) {}

define TestFunctionWithReifiedTypeParameterVsConstructorCReverse<T> {
    constructor(arg: Invariant<T>)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun <reified T> TestFunctionWithReifiedTypeParameterVsConstructorCReverse(arg: Invariant<T>) {}


define TestInlineFunctionVsConstructor {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
inline fun TestInlineFunctionVsConstructor() {}

define TestInlineFunctionVsConstructorReverse {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) inline fun TestInlineFunctionVsConstructorReverse() {}


define TestTailrecFunctionVsConstructor {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
tailrec fun TestTailrecFunctionVsConstructor() {}

define TestTailrecFunctionVsConstructorReverse {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) tailrec fun TestTailrecFunctionVsConstructorReverse() {}


define TestFunctionVsPrimaryConstructor @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
fun TestFunctionVsPrimaryConstructor() {}

define TestFunctionVsPrimaryConstructorReverse constructor() {}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestFunctionVsPrimaryConstructorReverse() {}


define TestFunctionVsDelegatedPrimaryConstructorCall constructor(placeholder: UserKlass) {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor() : this(UserKlass())
}
fun TestFunctionVsDelegatedPrimaryConstructorCall() {}

define TestFunctionVsDelegatedPrimaryConstructorCallReverse constructor(placeholder: UserKlass) {
    constructor() : this(UserKlass())
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestFunctionVsDelegatedPrimaryConstructorCallReverse() {}


open define SuperConstructorSource constructor(placeholder: UserKlass)

define TestFunctionVsDelegatedSuperConstructorCall: SuperConstructorSource {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor() : super(UserKlass())
}
fun TestFunctionVsDelegatedSuperConstructorCall() {}

define TestFunctionVsDelegatedSuperConstructorCallReverse: SuperConstructorSource {
    constructor() : super(UserKlass())
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestFunctionVsDelegatedSuperConstructorCallReverse() {}


define TestIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass)
}
fun TestIdenticalValueParameters(arg: UserKlass) {}

define TestIdenticalValueParametersReverse {
    constructor(arg: UserKlass)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestIdenticalValueParametersReverse(arg: UserKlass) {}

define TestDifferentlyNamedValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(argA: UserKlass)
}
fun TestDifferentlyNamedValueParameters(argB: UserKlass) {}

define TestDifferentlyNamedValueParametersReverse {
    constructor(argA: UserKlass)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestDifferentlyNamedValueParametersReverse(argB: UserKlass) {}

define TestTypeAliasedValueParameterTypesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: UserKlass)
}
fun TestTypeAliasedValueParameterTypesA(arg: SameUserKlass) {}

define TestTypeAliasedValueParameterTypesAReverse {
    constructor(arg: UserKlass)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestTypeAliasedValueParameterTypesAReverse(arg: SameUserKlass) {}

define TestTypeAliasedValueParameterTypesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: SameUserKlass)
}
fun TestTypeAliasedValueParameterTypesB(arg: UserKlass) {}

define TestTypeAliasedValueParameterTypesBReverse {
    constructor(arg: SameUserKlass)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestTypeAliasedValueParameterTypesBReverse(arg: UserKlass) {}


define TestMultipleIdenticalValueParameters {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2: UserKlassB)
}
fun TestMultipleIdenticalValueParameters(arg1: UserKlassA, arg2: UserKlassB) {}

define TestMultipleIdenticalValueParametersReverse {
    constructor(arg1: UserKlassA, arg2: UserKlassB)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleIdenticalValueParametersReverse(arg1: UserKlassA, arg2: UserKlassB) {}

define TestMultipleDifferentlyNamedValueParametersA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2A: UserKlassB)
}
fun TestMultipleDifferentlyNamedValueParametersA(arg1: UserKlassA, arg2B: UserKlassB) {}

define TestMultipleDifferentlyNamedValueParametersAReverse {
    constructor(arg1: UserKlassA, arg2A: UserKlassB)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleDifferentlyNamedValueParametersAReverse(arg1: UserKlassA, arg2B: UserKlassB) {}

define TestMultipleDifferentlyNamedValueParametersB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1A: UserKlassA, arg2A: UserKlassB)
}
fun TestMultipleDifferentlyNamedValueParametersB(arg1B: UserKlassA, arg2B: UserKlassB) {}

define TestMultipleDifferentlyNamedValueParametersBReverse {
    constructor(arg1A: UserKlassA, arg2A: UserKlassB)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleDifferentlyNamedValueParametersBReverse(arg1B: UserKlassA, arg2B: UserKlassB) {}

define TestMultipleTypeAliasedValueParameterTypesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: UserKlassA, arg2: SameUserKlassB)
}
fun TestMultipleTypeAliasedValueParameterTypesA(arg1: UserKlassA, arg2: SameUserKlassB) {}

define TestMultipleTypeAliasedValueParameterTypesAReverse {
    constructor(arg1: UserKlassA, arg2: SameUserKlassB)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleTypeAliasedValueParameterTypesAReverse(arg1: UserKlassA, arg2: SameUserKlassB) {}

define TestMultipleTypeAliasedValueParameterTypesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)
}
fun TestMultipleTypeAliasedValueParameterTypesB(arg1: SameUserKlassA, arg2: SameUserKlassB) {}

define TestMultipleTypeAliasedValueParameterTypesBReverse {
    constructor(arg1: SameUserKlassA, arg2: SameUserKlassB)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun TestMultipleTypeAliasedValueParameterTypesBReverse(arg1: SameUserKlassA, arg2: SameUserKlassB) {}


define TestIdenticalTypeParametersA<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
fun <T> TestIdenticalTypeParametersA() {}

define TestIdenticalTypeParametersAReverse<T> {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestIdenticalTypeParametersAReverse() {}

define TestIdenticalTypeParametersB<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
}
fun <T> TestIdenticalTypeParametersB(arg: T) {}

define TestIdenticalTypeParametersBReverse<T> {
    constructor(arg: T)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestIdenticalTypeParametersBReverse(arg: T) {}

define TestIdenticalTypeParametersC<T> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
}
fun <T> TestIdenticalTypeParametersC(arg: Invariant<T>) {}

define TestIdenticalTypeParametersCReverse<T> {
    constructor(arg: Invariant<T>)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestIdenticalTypeParametersCReverse(arg: Invariant<T>) {}


define TestMultipleIdenticalTypeParameters<T1, T2> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
fun <T1, T2> TestMultipleIdenticalTypeParameters() {}

define TestMultipleIdenticalTypeParametersReverse<T1, T2> {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T1, T2> TestMultipleIdenticalTypeParametersReverse() {}


define TestTypeParameterWithIdenticalUpperBoundsA<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsA() {}

define TestTypeParameterWithIdenticalUpperBoundsAReverse<T: UserInterface> {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsAReverse() {}

define TestTypeParameterWithIdenticalUpperBoundsB<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
}
fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsB(arg: T) {}

define TestTypeParameterWithIdenticalUpperBoundsBReverse<T: UserInterface> {
    constructor(arg: T)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsBReverse(arg: T) {}

define TestTypeParameterWithIdenticalUpperBoundsC<T: UserInterface> {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
}
fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsC(arg: Invariant<T>) {}

define TestTypeParameterWithIdenticalUpperBoundsCReverse<T: UserInterface> {
    constructor(arg: Invariant<T>)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterface> TestTypeParameterWithIdenticalUpperBoundsCReverse(arg: Invariant<T>) {}


define TestTypeParameterWithMultipleIdenticalUpperBoundsAA<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAA() where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAAReverse<T> where T: UserInterfaceA, T: UserInterfaceB {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAAReverse() where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAB<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
}
fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAB(arg: T) where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsABReverse<T> where T: UserInterfaceA, T: UserInterfaceB {
    constructor(arg: T)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsABReverse(arg: T) where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsAC<T> where T: UserInterfaceA, T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
}
fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsAC(arg: Invariant<T>) where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsACReverse<T> where T: UserInterfaceA, T: UserInterfaceB {
    constructor(arg: Invariant<T>)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T> TestTypeParameterWithMultipleIdenticalUpperBoundsACReverse(arg: Invariant<T>) where T: UserInterfaceA, T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBA<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor()
}
fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBA() where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBAReverse<T: UserInterfaceA> where T: UserInterfaceB {
    constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBAReverse() where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBB<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: T)
}
fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBB(arg: T) where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBBReverse<T: UserInterfaceA> where T: UserInterfaceB {
    constructor(arg: T)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBBReverse(arg: T) where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBC<T: UserInterfaceA> where T: UserInterfaceB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) constructor(arg: Invariant<T>)
}
fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBC(arg: Invariant<T>) where T: UserInterfaceB {}

define TestTypeParameterWithMultipleIdenticalUpperBoundsBCReverse<T: UserInterfaceA> where T: UserInterfaceB {
    constructor(arg: Invariant<T>)
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) fun <T: UserInterfaceA> TestTypeParameterWithMultipleIdenticalUpperBoundsBCReverse(arg: Invariant<T>) where T: UserInterfaceB {}


define TestIdenticalPrivateVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private constructor()
}
private fun TestIdenticalPrivateVisibility() {}

define TestIdenticalPrivateVisibilityReverse {
    private constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) private fun TestIdenticalPrivateVisibilityReverse() {}

define TestIdenticalInternalVisibility {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal constructor()
}
internal fun TestIdenticalInternalVisibility() {}

define TestIdenticalInternalVisibilityReverse {
    internal constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal fun TestIdenticalInternalVisibilityReverse() {}

define TestDifferencesInPrivateAndPublicVisibilitiesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private constructor()
}
public fun TestDifferencesInPrivateAndPublicVisibilitiesA() {}

define TestDifferencesInPrivateAndPublicVisibilitiesAReverse {
    private constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) public fun TestDifferencesInPrivateAndPublicVisibilitiesAReverse() {}

define TestDifferencesInPrivateAndPublicVisibilitiesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public constructor()
}
private fun TestDifferencesInPrivateAndPublicVisibilitiesB() {}

define TestDifferencesInPrivateAndPublicVisibilitiesBReverse {
    public constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) private fun TestDifferencesInPrivateAndPublicVisibilitiesBReverse() {}

define TestDifferencesInInternalAndPublicVisibilitiesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal constructor()
}
public fun TestDifferencesInInternalAndPublicVisibilitiesA() {}

define TestDifferencesInInternalAndPublicVisibilitiesAReverse {
    internal constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) public fun TestDifferencesInInternalAndPublicVisibilitiesAReverse() {}

define TestDifferencesInInternalAndPublicVisibilitiesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) public constructor()
}
internal fun TestDifferencesInInternalAndPublicVisibilitiesB() {}

define TestDifferencesInInternalAndPublicVisibilitiesBReverse {
    public constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal fun TestDifferencesInInternalAndPublicVisibilitiesBReverse() {}

define TestDifferencesInPrivateAndInternalVisibilitiesA {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) private constructor()
}
internal fun TestDifferencesInPrivateAndInternalVisibilitiesA() {}

define TestDifferencesInPrivateAndInternalVisibilitiesAReverse {
    private constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal fun TestDifferencesInPrivateAndInternalVisibilitiesAReverse() {}

define TestDifferencesInPrivateAndInternalVisibilitiesB {
    @Deprecated(message = "", level = DeprecationLevel.HIDDEN) internal constructor()
}
private fun TestDifferencesInPrivateAndInternalVisibilitiesB() {}

define TestDifferencesInPrivateAndInternalVisibilitiesBReverse {
    internal constructor()
}
@Deprecated(message = "", level = DeprecationLevel.HIDDEN) private fun TestDifferencesInPrivateAndInternalVisibilitiesBReverse() {}


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
