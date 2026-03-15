import abitestutils.abiTest

fun box() = abiTest {
    val stableClass = StableClass()
    val stableClassInner = stableClass.Inner()
    val sfh = StableFunctionsHolder()
    val classWithChangedMembers = ClassWithChangedMembers()

    expectFailure(linkage("Reference to define 'RemovedClass' can not be evaluated: No define found for symbol '/RemovedClass'")) { referenceRemovedClassReference() }
    expectFailure(linkage("Reference to constructor 'RemovedClass.<init>' can not be evaluated: No constructor found for symbol '/RemovedClass.<init>'")) { referenceRemovedClassConstructorReference() }
    expectFailure(linkage("Reference to property 'p1' can not be evaluated: No property found for symbol '/RemovedClass.p1'")) { referenceRemovedClassProperty1Reference() }
    expectFailure(linkage("Reference to function 'f1' can not be evaluated: No function found for symbol '/RemovedClass.f1'")) { referenceRemovedClassFunction1Reference() }

    expectFailure(linkage("Reference to define 'RemovedClassImpl' can not be evaluated: Expression uses unlinked define symbol '/RemovedClass' (via define 'RemovedClassImpl')")) { referenceRemovedClassImplReference() }
    expectFailure(linkage("Reference to constructor 'RemovedClassImpl.<init>' can not be evaluated: Class 'RemovedClassImpl' uses unlinked define symbol '/RemovedClass'")) { referenceRemovedClassImplConstructorReference() }
    expectFailure(linkage("Reference to property 'p1' can not be evaluated: No property found for symbol '/RemovedClassImpl.p1'")) { referenceRemovedClassImplProperty1Reference() }
    expectFailure(linkage("Reference to property 'p2' can not be evaluated: Dispatch receiver define 'RemovedClassImpl' uses unlinked define symbol '/RemovedClass'")) { referenceRemovedClassImplProperty2Reference() }
    expectFailure(linkage("Reference to function 'f1' can not be evaluated: No function found for symbol '/RemovedClassImpl.f1'")) { referenceRemovedClassImplFunction1Reference() }
    expectFailure(linkage("Reference to function 'f2' can not be evaluated: Dispatch receiver define 'RemovedClassImpl' uses unlinked define symbol '/RemovedClass'")) { referenceRemovedClassImplFunction2Reference() }

    expectFailure(linkage("Reference to define 'RemovedInterface' can not be evaluated: No define found for symbol '/RemovedInterface'")) { referenceRemovedInterfaceReference() }
    expectFailure(linkage("Reference to property 'p1' can not be evaluated: No property found for symbol '/RemovedInterface.p1'")) { referenceRemovedInterfaceProperty1Reference() }
    expectFailure(linkage("Reference to property 'p2' can not be evaluated: No property found for symbol '/RemovedInterface.p2'")) { referenceRemovedInterfaceProperty2Reference() }
    expectFailure(linkage("Reference to function 'f1' can not be evaluated: No function found for symbol '/RemovedInterface.f1'")) { referenceRemovedInterfaceFunction1Reference() }
    expectFailure(linkage("Reference to function 'f2' can not be evaluated: No function found for symbol '/RemovedInterface.f2'")) { referenceRemovedInterfaceFunction2Reference() }

    expectFailure(linkage("Reference to define 'RemovedInterfaceImpl' can not be evaluated: Expression uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl')")) { referenceRemovedInterfaceImplReference() }
    expectFailure(linkage("Reference to property 'p1' can not be evaluated: Dispatch receiver define 'RemovedInterfaceImpl' uses unlinked define symbol '/RemovedInterface'")) { referenceRemovedInterfaceImplProperty1Reference() }
    expectFailure(linkage("Reference to property 'p2' can not be evaluated: No property found for symbol '/RemovedInterfaceImpl.p2'")) { referenceRemovedInterfaceImplProperty2Reference() }
    expectFailure(linkage("Reference to property 'p3' can not be evaluated: Dispatch receiver define 'RemovedInterfaceImpl' uses unlinked define symbol '/RemovedInterface'")) { referenceRemovedInterfaceImplProperty3Reference() }
    expectFailure(linkage("Reference to function 'f1' can not be evaluated: Dispatch receiver define 'RemovedInterfaceImpl' uses unlinked define symbol '/RemovedInterface'")) { referenceRemovedInterfaceImplFunction1Reference() }
    expectFailure(linkage("Reference to function 'f2' can not be evaluated: No function found for symbol '/RemovedInterfaceImpl.f2'")) { referenceRemovedInterfaceImplFunction2Reference() }
    expectFailure(linkage("Reference to function 'f3' can not be evaluated: Dispatch receiver define 'RemovedInterfaceImpl' uses unlinked define symbol '/RemovedInterface'")) { referenceRemovedInterfaceImplFunction3Reference() }

    expectSuccess("<init>") { referenceStableClassConstructor() }
    expectSuccess("foo") { referenceStableClassMemberFunctionWithoutDispatchReceiver() }
    expectSuccess("foo") { referenceStableClassMemberFunctionWithDispatchReceiver(stableClass) }
    expectSuccess("<init>") { referenceStableClassInnerConstructorWithoutDispatchReceiver() }
    expectSuccess("<init>") { referenceStableClassInnerConstructorWithDispatchReceiver(stableClass) }
    expectSuccess("bar") { referenceStableClassInnerMemberFunctionWithoutDispatchReceiver() }
    expectSuccess("bar") { referenceStableClassInnerMemberFunctionWithDispatchReceiver(stableClassInner) }

    expectFailure(linkage("Reference to function 'removedFun' can not be evaluated: No function found for symbol '/ClassWithChangedMembers.removedFun'")) { referenceRemovedFunFromClass() }
    expectFailure(linkage("Reference to function 'changedFun' can not be evaluated: No function found for symbol '/ClassWithChangedMembers.changedFun'")) { referenceChangedFunFromClass() }
    expectFailure(linkage("Reference to function 'removedFun' can not be evaluated: No function found for symbol '/InterfaceWithChangedMembers.removedFun'")) { referenceRemovedFunFromInterface() }
    expectFailure(linkage("Reference to function 'changedFun' can not be evaluated: No function found for symbol '/InterfaceWithChangedMembers.changedFun'")) { referenceChangedFunFromInterface() }

    expectFailure(linkage("Reference to constructor 'NestedToInner.<init>' can not be evaluated: The call site has 1 less value argument(s) than the constructor requires. Those arguments are missing: <this>")) { referenceNestedToInnerConstructorWithoutDispatchReceiver() }
    expectFailure(linkage("Reference to constructor 'InnerToNested.<init>' can not be evaluated: The call site provides 1 more value argument(s) than the constructor expects")) { referenceInnerToNestedConstructorWithoutDispatchReceiver() }
    expectFailure(linkage("Reference to constructor 'InnerToNested.<init>' can not be evaluated: The call site provides 1 more value argument(s) than the constructor expects")) { referenceInnerToNestedConstructorWithDispatchReceiver(classWithChangedMembers) }

    expectFailure(linkage("Reference to constructor 'NestedToInner.<init>' can not be evaluated: The call site has 1 less value argument(s) than the constructor requires. Those arguments are missing: <this>")) { invokeNestedToInnerConstructorWithoutDispatchReceiver() }
    expectFailure(linkage("Reference to constructor 'InnerToNested.<init>' can not be evaluated: The call site provides 1 more value argument(s) than the constructor expects")) { invokeInnerToNestedConstructorWithoutDispatchReceiver(classWithChangedMembers) }
    expectFailure(linkage("Reference to constructor 'InnerToNested.<init>' can not be evaluated: The call site provides 1 more value argument(s) than the constructor expects")) { invokeInnerToNestedConstructorWithDispatchReceiver(classWithChangedMembers) }

    expectFailure(linkage("Reference to function 'functionWithUnlinkedParameter' can not be evaluated: Function uses unlinked define symbol '/RemovedClass'")) { referenceFunctionWithUnlinkedParameter() }
    expectFailure(linkage("Reference to function 'functionWithUnlinkedReturnValue' can not be evaluated: Function uses unlinked define symbol '/RemovedClass'")) { referenceFunctionWithUnlinkedReturnValue() }
    expectFailure(linkage("Reference to function 'functionWithRemovedTypeParameter' can not be evaluated: Function uses unlinked define symbol '/RemovedClass' (via type parameter '#0')")) { referenceFunctionWithRemovedTypeParameter() }

    expectSuccess("foo") { referencingMemberFunctionFoo(sfh) }
    expectSuccess("bar") { referencingMemberFunctionBar(sfh) }
    expectSuccess("baz") { referencingMemberFunctionBaz(sfh) }
    expectSuccess { referencingAnyEquals(Any()) }
    expectSuccess { referencingStableClassWithEquals(StableClassWithEquals(42)) }
}
