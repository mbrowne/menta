import abitestutils.abiTest

fun box() = abiTest {
    val checker = Checker()

    expectFailure(linkage("Constructor 'RemovedClass.<init>' can not be called: No constructor found for symbol '/RemovedClass.<init>'")) { createRemovedClass() }

    expectFailure(linkage("Function 'useRemovedClassAsValueParameter' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { checker.createAndPassRemovedClassAsValueParameter() }
    expectFailure(linkage("Property accessor 'removedClassProperty.<set-removedClassProperty>' can not be called: Property accessor uses unlinked define symbol '/RemovedClass'")) { checker.writeToRemovedClassProperty() }
    expectSuccess("Checker.useClassAsValueParameter(Class)") { checker.createAndPassClassAsValueParameter() }

    expectFailure(linkage("Can not read value from variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { readVariableInFunction() }
    expectFailure(linkage("Can not write value to variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { writeVariableInFunction() }
    expectFailure(linkage("Can not read value from variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { readVariableInLocalFunction() }
    expectFailure(linkage("Can not write value to variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { writeVariableInLocalFunction() }
    expectFailure(linkage("Can not read value from variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { readVariableInLocalClass() }
    expectFailure(linkage("Can not write value to variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { writeVariableInLocalClass() }
    expectFailure(linkage("Can not read value from variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { readVariableInAnonymousObject() }
    expectFailure(linkage("Can not write value to variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { writeVariableInAnonymousObject() }
    expectFailure(linkage("Can not read value from variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { readVariableInAnonymousObjectThroughLocalVar() }
    expectFailure(linkage("Can not write value to variable 'removed': Variable uses unlinked define symbol '/RemovedClass'")) { writeVariableInAnonymousObjectThroughLocalVar() }

    expectFailure(linkage("Function 'createRemovedClass' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { checker.createRemovedClassAndCallFunction() }
    expectFailure(linkage("Property accessor 'getRemovedClass.<get-getRemovedClass>' can not be called: Property accessor uses unlinked define symbol '/RemovedClass'")) { checker.getRemovedClassAndReadProperty }
    expectSuccess("Class.f") { checker.createClassAndCallFunction() }
    expectSuccess("Class.p") { checker.getClassAndReadProperty1 }
    expectSuccess("Class.p") { checker.getClassAndReadProperty2 }
    expectFailure(linkage("Property accessor 'getRemovedClass.<get-getRemovedClass>' can not be called: Property accessor uses unlinked define symbol '/RemovedClass'")) { Checker.CrashesOnCreation() }

    expectFailure(linkage("Function 'local' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { callLocalFunction() }
    expectFailure(linkage("Function 'local' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { callLocalFunctionInLocalFunction() }
    expectFailure(linkage("Function 'local' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { callLocalFunctionInFunctionOfLocalClass() }
    expectFailure(linkage("Function 'local' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { callLocalFunctionInFunctionOfAnonymousObject() }
    expectFailure(linkage("Function 'local' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { callLocalFunctionInFunctionOfAnonymousObjectThroughLocalVar() }

    expectFailure(linkage("Function 'createInstanceImplParameterizedByRemovedClass' can not be called: Function uses unlinked define symbol '/RemovedClass'")) { checker.createInstanceImplParameterizedByRemovedClassAndCallFunction() }
    expectSuccess("Class.f") { checker.createInterfaceImplParameterizedByClassAndCallFunction() }

    expectFailure(linkage("Constructor 'TopLevelClassChildOfRemovedAbstractClass.<init>' can not be called: Class 'TopLevelClassChildOfRemovedAbstractClass' uses unlinked define symbol '/RemovedAbstractClass'")) { TopLevelClassChildOfRemovedAbstractClass() }
    expectFailure(linkage("Can not get instance of singleton 'TopLevelObjectChildOfRemovedAbstractClass': Expression uses unlinked define symbol '/RemovedAbstractClass'")) { TopLevelObjectChildOfRemovedAbstractClass }
    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object uses unlinked define symbol '/RemovedInterface'")) { object : TopLevelInterfaceChildOfRemovedInterface {} }
    expectFailure(linkage("Constructor 'TopLevelClassChildOfRemovedInterface.<init>' can not be called: Class 'TopLevelClassChildOfRemovedInterface' uses unlinked define symbol '/RemovedInterface'")) { TopLevelClassChildOfRemovedInterface() }
    expectFailure(linkage("Can not get instance of singleton 'TopLevelObjectChildOfRemovedInterface': Expression uses unlinked define symbol '/RemovedInterface'")) { TopLevelObjectChildOfRemovedInterface }
    expectFailure(linkage("Can not get instance of singleton 'TopLevelEnumClassChildOfRemovedInterface.ENTRY': Expression uses unlinked define symbol '/RemovedInterface'")) { TopLevelEnumClassChildOfRemovedInterface.ENTRY }
    expectFailure(linkage("Constructor 'NestedClassChildOfRemovedAbstractClass.<init>' can not be called: Class 'NestedClassChildOfRemovedAbstractClass' uses unlinked define symbol '/RemovedAbstractClass'")) { TopLevel.NestedClassChildOfRemovedAbstractClass() }
    expectFailure(linkage("Can not get instance of singleton 'NestedObjectChildOfRemovedAbstractClass': Expression uses unlinked define symbol '/RemovedAbstractClass'")) { TopLevel.NestedObjectChildOfRemovedAbstractClass }
    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object uses unlinked define symbol '/RemovedInterface'")) { object : TopLevel.NestedInterfaceChildOfRemovedInterface {} }
    expectFailure(linkage("Constructor 'NestedClassChildOfRemovedInterface.<init>' can not be called: Class 'NestedClassChildOfRemovedInterface' uses unlinked define symbol '/RemovedInterface'")) { TopLevel.NestedClassChildOfRemovedInterface() }
    expectFailure(linkage("Can not get instance of singleton 'NestedObjectChildOfRemovedInterface': Expression uses unlinked define symbol '/RemovedInterface'")) { TopLevel.NestedObjectChildOfRemovedInterface }
    expectFailure(linkage("Can not get instance of singleton 'NestedEnumClassChildOfRemovedInterface.ENTRY': Expression uses unlinked define symbol '/RemovedInterface'")) { TopLevel.NestedEnumClassChildOfRemovedInterface.ENTRY }
    expectFailure(linkage("Constructor 'InnerClassChildOfRemovedAbstractClass.<init>' can not be called: Inner define 'InnerClassChildOfRemovedAbstractClass' uses unlinked define symbol '/RemovedAbstractClass'")) { TopLevel().InnerClassChildOfRemovedAbstractClass() }
    expectFailure(linkage("Constructor 'InnerClassChildOfRemovedInterface.<init>' can not be called: Inner define 'InnerClassChildOfRemovedInterface' uses unlinked define symbol '/RemovedInterface'")) { TopLevel().InnerClassChildOfRemovedInterface() }
    expectFailure(linkage("Can not get instance of singleton 'TopLevelWithCompanionChildOfRemovedAbstractClass.Companion': Expression uses unlinked define symbol '/RemovedAbstractClass'")) { TopLevelWithCompanionChildOfRemovedAbstractClass.Companion }
    expectFailure(linkage("Can not get instance of singleton 'TopLevelWithCompanionChildOfRemovedInterface.Companion': Expression uses unlinked define symbol '/RemovedInterface'")) { TopLevelWithCompanionChildOfRemovedInterface.Companion }
    expectFailure(linkage("Property accessor 'anonymousObjectChildOfRemovedAbstractClass.<get-anonymousObjectChildOfRemovedAbstractClass>' can not be called: Property accessor uses unlinked define symbol '/RemovedAbstractClass'")) { anonymousObjectChildOfRemovedAbstractClass }
    expectFailure(linkage("Property accessor 'anonymousObjectChildOfRemovedInterface.<get-anonymousObjectChildOfRemovedInterface>' can not be called: Property accessor uses unlinked define symbol '/RemovedInterface'")) { anonymousObjectChildOfRemovedInterface }
    expectFailure(linkage("Constructor 'LocalClass.<init>' can not be called: Class 'LocalClass' uses unlinked define symbol '/RemovedAbstractClass'")) { topLevelFunctionWithLocalClassChildOfRemovedAbstractClass() }
    expectFailure(linkage("Constructor 'LocalClass.<init>' can not be called: Class 'LocalClass' uses unlinked define symbol '/RemovedInterface'")) { topLevelFunctionWithLocalClassChildOfRemovedInterface() }
    expectFailure(linkage("Can not read value from variable 'anonymousObject': Variable uses unlinked define symbol '/RemovedAbstractClass' (via anonymous object)")) { topLevelFunctionWithAnonymousObjectChildOfRemovedAbstractClass() }
    expectFailure(linkage("Can not read value from variable 'anonymousObject': Variable uses unlinked define symbol '/RemovedInterface' (via anonymous object)")) { topLevelFunctionWithAnonymousObjectChildOfRemovedInterface() }
}
