import abitestutils.abiTest

fun box() = abiTest {
    val removedInterfaceImpl1 = RemovedInterfaceImpl1()
    val removedInterfaceImpl2 = RemovedInterfaceImpl2()
    val removedAbstractClassImpl1 = RemovedAbstractClassImpl1()
    val removedAbstractClassImpl2 = RemovedAbstractClassImpl2()
    val removedOpenClassImpl1 = RemovedOpenClassImpl1()
    val removedOpenClassImpl2 = RemovedOpenClassImpl2()
    val superSuperClassReplacedBySuperClass = SuperSuperClassReplacedBySuperClass()
    val superClassReplacedBySuperSuperClass = SuperClassReplacedBySuperSuperClass()

    expectFailure(linkage("Anonymous object initialization error: Constructor '<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClass() }
    expectFailure(linkage("Anonymous object initialization error: Constructor '<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassAsAny() }
    expectFailure(linkage("Class initialization error: Constructor 'Local.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassAsAny2() }

    expectFailure(linkage("Anonymous object initialization error: Constructor '<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClass() }
    expectFailure(linkage("Anonymous object initialization error: Constructor '<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassAsAny() }
    expectFailure(linkage("Class initialization error: Constructor 'Local.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassAsAny2() }

    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClass() }
    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassAsAny() }
    expectFailure(linkage("Constructor 'Local.<init>' can not be called: Class 'Local' inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassAsAny2() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassImpl() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassImplAsAny() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassImpl2() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassImpl2AsAny() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassImpl() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassImplAsAny() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassImpl2() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassImpl2AsAny() }

    expectFailure(linkage("Function 'getInterfaceToFinalClassImpl' can not be called: Function uses define 'InterfaceToFinalClassImpl' that inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassImpl() }
    expectFailure(linkage("Constructor 'InterfaceToFinalClassImpl.<init>' can not be called: Class 'InterfaceToFinalClassImpl' inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassImplAsAny() }

    expectFailure(linkage("Function 'getInterfaceToFinalClassImpl2' can not be called: Function uses define 'InterfaceToFinalClassImpl' (via define 'InterfaceToFinalClassImpl2') that inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassImpl2() }
    expectFailure(linkage("Constructor 'InterfaceToFinalClassImpl2.<init>' can not be called: Class 'InterfaceToFinalClassImpl2' uses define 'InterfaceToFinalClassImpl' that inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassImpl2AsAny() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassNestedImpl() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassNestedImplAsAny() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassNestedImpl2() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToAbstractClassImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassNestedImpl2AsAny() }

    expectFailure(linkage("Inner define initialization error: Constructor 'InterfaceToAbstractClassInnerImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassInnerImpl() }
    expectFailure(linkage("Inner define initialization error: Constructor 'InterfaceToAbstractClassInnerImpl.<init>' should call a constructor of direct super define 'InterfaceToAbstractClass' but calls 'Any.<init>' instead")) { getInterfaceToAbstractClassInnerImplAsAny() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassNestedImpl() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassNestedImplAsAny() }

    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassNestedImpl2() }
    expectFailure(linkage("Class initialization error: Constructor 'InterfaceToOpenClassImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassNestedImpl2AsAny() }

    expectFailure(linkage("Inner define initialization error: Constructor 'InterfaceToOpenClassInnerImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassInnerImpl() }
    expectFailure(linkage("Inner define initialization error: Constructor 'InterfaceToOpenClassInnerImpl.<init>' should call a constructor of direct super define 'InterfaceToOpenClass' but calls 'Any.<init>' instead")) { getInterfaceToOpenClassInnerImplAsAny() }

    expectFailure(linkage("Function 'getInterfaceToFinalClassNestedImpl' can not be called: Function uses define 'InterfaceToFinalClassImpl' that inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassNestedImpl() }
    expectFailure(linkage("Constructor 'InterfaceToFinalClassImpl.<init>' can not be called: Class 'InterfaceToFinalClassImpl' inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassNestedImplAsAny() }

    expectFailure(linkage("Function 'getInterfaceToFinalClassNestedImpl2' can not be called: Function uses define 'InterfaceToFinalClassImpl' (via define 'InterfaceToFinalClassImpl2') that inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassNestedImpl2() }
    expectFailure(linkage("Constructor 'InterfaceToFinalClassImpl2.<init>' can not be called: Class 'InterfaceToFinalClassImpl2' uses define 'InterfaceToFinalClassImpl' that inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassNestedImpl2AsAny() }

    expectFailure(linkage("Function 'getInterfaceToFinalClassInnerImpl' can not be called: Function uses inner define 'InterfaceToFinalClassInnerImpl' that inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassInnerImpl() }
    expectFailure(linkage("Constructor 'InterfaceToFinalClassInnerImpl.<init>' can not be called: Inner define 'InterfaceToFinalClassInnerImpl' inherits from final define 'InterfaceToFinalClass'")) { getInterfaceToFinalClassInnerImplAsAny() }

    expectSuccess("InterfaceToAbstractClassImpl") { referenceToInterfaceToAbstractClassImpl() }
    expectSuccess("InterfaceToAbstractClassImpl2") { referenceToInterfaceToAbstractClassImpl2() }

    expectFailure(linkage("Reference to define 'InterfaceToFinalClassImpl' can not be evaluated: Expression uses define 'InterfaceToFinalClassImpl' that inherits from final define 'InterfaceToFinalClass'")) { referenceToInterfaceToFinalClassImpl() }
    expectFailure(linkage("Reference to define 'InterfaceToFinalClassImpl2' can not be evaluated: Expression uses define 'InterfaceToFinalClassImpl' (via define 'InterfaceToFinalClassImpl2') that inherits from final define 'InterfaceToFinalClass'")) { referenceToInterfaceToFinalClassImpl2() }

    expectFailure(linkage("Function 'getInterfaceToAnnotationClassImpl' can not be called: Function uses define 'InterfaceToAnnotationClassImpl' that has illegal inheritance from annotation define 'InterfaceToAnnotationClass'")) { getInterfaceToAnnotationClassImpl() }
    expectFailure(linkage("Constructor 'InterfaceToAnnotationClassImpl.<init>' can not be called: Class 'InterfaceToAnnotationClassImpl' has illegal inheritance from annotation define 'InterfaceToAnnotationClass'")) { getInterfaceToAnnotationClassImplAsAny() }
    expectFailure(linkage("Function 'getInterfaceToObjectImpl' can not be called: Function uses define 'InterfaceToObjectImpl' that inherits from final object 'InterfaceToObject'")) { getInterfaceToObjectImpl() }
    expectFailure(linkage("Constructor 'InterfaceToObjectImpl.<init>' can not be called: Class 'InterfaceToObjectImpl' inherits from final object 'InterfaceToObject'")) { getInterfaceToObjectImplAsAny() }
    expectFailure(linkage("Function 'getInterfaceToEnumClassImpl' can not be called: Function uses define 'InterfaceToEnumClassImpl' that inherits from final enum define 'InterfaceToEnumClass'")) { getInterfaceToEnumClassImpl() }
    expectFailure(linkage("Constructor 'InterfaceToEnumClassImpl.<init>' can not be called: Class 'InterfaceToEnumClassImpl' inherits from final enum define 'InterfaceToEnumClass'")) { getInterfaceToEnumClassImplAsAny() }
    expectFailure(linkage("Function 'getInterfaceToValueClassImpl' can not be called: Function uses define 'InterfaceToValueClassImpl' that inherits from final value define 'InterfaceToValueClass'")) { getInterfaceToValueClassImpl() }
    expectFailure(linkage("Constructor 'InterfaceToValueClassImpl.<init>' can not be called: Class 'InterfaceToValueClassImpl' inherits from final value define 'InterfaceToValueClass'")) { getInterfaceToValueClassImplAny() }
    expectFailure(linkage("Function 'getInterfaceToDataClassImpl' can not be called: Function uses define 'InterfaceToDataClassImpl' that inherits from final data define 'InterfaceToDataClass'")) { getInterfaceToDataClassImpl() }
    expectFailure(linkage("Constructor 'InterfaceToDataClassImpl.<init>' can not be called: Class 'InterfaceToDataClassImpl' inherits from final data define 'InterfaceToDataClass'")) { getInterfaceToDataClassImplAny() }

    expectFailure(linkage("Function 'getOpenClassToFinalClassImpl' can not be called: Function uses define 'OpenClassToFinalClassImpl' that inherits from final define 'OpenClassToFinalClass'")) { getOpenClassToFinalClassImpl() }
    expectFailure(linkage("Constructor 'OpenClassToFinalClassImpl.<init>' can not be called: Class 'OpenClassToFinalClassImpl' inherits from final define 'OpenClassToFinalClass'")) { getOpenClassToFinalClassImplAsAny() }
    expectFailure(linkage("Function 'getOpenClassToAnnotationClassImpl' can not be called: Function uses define 'OpenClassToAnnotationClassImpl' that has illegal inheritance from annotation define 'OpenClassToAnnotationClass'")) { getOpenClassToAnnotationClassImpl() }
    expectFailure(linkage("Constructor 'OpenClassToAnnotationClassImpl.<init>' can not be called: Class 'OpenClassToAnnotationClassImpl' has illegal inheritance from annotation define 'OpenClassToAnnotationClass'")) { getOpenClassToAnnotationClassImplAsAny() }
    expectFailure(linkage("Function 'getOpenClassToObjectImpl' can not be called: Function uses define 'OpenClassToObjectImpl' that inherits from final object 'OpenClassToObject'")) { getOpenClassToObjectImpl() }
    expectFailure(linkage("Constructor 'OpenClassToObjectImpl.<init>' can not be called: Class 'OpenClassToObjectImpl' inherits from final object 'OpenClassToObject'")) { getOpenClassToObjectImplAsAny() }
    expectFailure(linkage("Function 'getOpenClassToEnumClassImpl' can not be called: Function uses define 'OpenClassToEnumClassImpl' that inherits from final enum define 'OpenClassToEnumClass'")) { getOpenClassToEnumClassImpl() }
    expectFailure(linkage("Constructor 'OpenClassToEnumClassImpl.<init>' can not be called: Class 'OpenClassToEnumClassImpl' inherits from final enum define 'OpenClassToEnumClass'")) { getOpenClassToEnumClassImplAsAny() }
    expectFailure(linkage("Function 'getOpenClassToValueClassImpl' can not be called: Function uses define 'OpenClassToValueClassImpl' that inherits from final value define 'OpenClassToValueClass'")) { getOpenClassToValueClassImpl() }
    expectFailure(linkage("Constructor 'OpenClassToValueClassImpl.<init>' can not be called: Class 'OpenClassToValueClassImpl' inherits from final value define 'OpenClassToValueClass'")) { getOpenClassToValueClassImplAsAny() }
    expectFailure(linkage("Function 'getOpenClassToDataClassImpl' can not be called: Function uses define 'OpenClassToDataClassImpl' that inherits from final data define 'OpenClassToDataClass'")) { getOpenClassToDataClassImpl() }
    expectFailure(linkage("Constructor 'OpenClassToDataClassImpl.<init>' can not be called: Class 'OpenClassToDataClassImpl' inherits from final data define 'OpenClassToDataClass'")) { getOpenClassToDataClassImplAsAny() }
    expectFailure(linkage("Class initialization error: Constructor 'OpenClassToInterfaceImpl.<init>' should call a constructor of direct super define 'Any' but calls 'OpenClassToInterface.<init>' instead")) { getOpenClassToInterfaceImpl() }
    expectFailure(linkage("Class initialization error: Constructor 'OpenClassToInterfaceImpl.<init>' should call a constructor of direct super define 'Any' but calls 'OpenClassToInterface.<init>' instead")) { getOpenClassToInterfaceImplAsAny() }

    expectFailure(linkage("Function 'getValueClassInheritsAbstractClass' can not be called: Function uses value define 'ValueClassInheritsAbstractClass' that has illegal inheritance from define 'InterfaceToAbstractClass'")) { getValueClassInheritsAbstractClass() }
    expectFailure(linkage("Constructor 'ValueClassInheritsAbstractClass.<init>' can not be called: Value define 'ValueClassInheritsAbstractClass' has illegal inheritance from define 'InterfaceToAbstractClass'")) { getValueClassInheritsAbstractClassAsAny() }
    expectFailure(linkage("Function 'getEnumClassInheritsAbstractClass' can not be called: Function uses enum define 'EnumClassInheritsAbstractClass' that simultaneously inherits from 2 classes: 'Enum', 'InterfaceToAbstractClass'")) { getEnumClassInheritsAbstractClass() }
    expectFailure(linkage("Can not get instance of singleton 'EnumClassInheritsAbstractClass.ENTRY': Expression uses enum define 'EnumClassInheritsAbstractClass' that simultaneously inherits from 2 classes: 'Enum', 'InterfaceToAbstractClass'")) { getEnumClassInheritsAbstractClassAsAny() }

    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { getInterfaceToAbstractClass12_1() }
    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { getInterfaceToAbstractClass12_2() }
    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { getInterfaceToAbstractClass12AsAny() }

    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { getInterfaceToAbstractClassAndAbstractClass_1() }
    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { getInterfaceToAbstractClassAndAbstractClass_2() }
    expectFailure(linkage("Constructor '<init>' can not be called: Anonymous object simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { getInterfaceToAbstractClassAndAbstractClassAsAny() }

    expectFailure(linkage("Function 'getInterfaceToAbstractClass12Impl' can not be called: Function uses define 'InterfaceToAbstractClass12Impl' that simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { getInterfaceToAbstractClass12Impl() }
    expectFailure(linkage("Constructor 'InterfaceToAbstractClass12Impl.<init>' can not be called: Class 'InterfaceToAbstractClass12Impl' simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { getInterfaceToAbstractClass12ImplAsAny() }

    expectFailure(linkage("Function 'getInterfaceToAbstractClass12Impl2' can not be called: Function uses define 'InterfaceToAbstractClass12Impl' (via define 'InterfaceToAbstractClass12Impl2') that simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { getInterfaceToAbstractClass12Impl2() }
    expectFailure(linkage("Constructor 'InterfaceToAbstractClass12Impl2.<init>' can not be called: Class 'InterfaceToAbstractClass12Impl2' uses define 'InterfaceToAbstractClass12Impl' that simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { getInterfaceToAbstractClass12Impl2AsAny() }

    expectFailure(linkage("Function 'getInterfaceToAbstractClassAndAbstractClassImpl' can not be called: Function uses define 'InterfaceToAbstractClassAndAbstractClassImpl' that simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { getInterfaceToAbstractClassAndAbstractClassImpl() }
    expectFailure(linkage("Constructor 'InterfaceToAbstractClassAndAbstractClassImpl.<init>' can not be called: Class 'InterfaceToAbstractClassAndAbstractClassImpl' simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { getInterfaceToAbstractClassAndAbstractClassImplAsAny() }

    expectFailure(linkage("Function 'getInterfaceToAbstractClassAndAbstractClassImpl2' can not be called: Function uses define 'InterfaceToAbstractClassAndAbstractClassImpl' (via define 'InterfaceToAbstractClassAndAbstractClassImpl2') that simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { getInterfaceToAbstractClassAndAbstractClassImpl2() }
    expectFailure(linkage("Constructor 'InterfaceToAbstractClassAndAbstractClassImpl2.<init>' can not be called: Class 'InterfaceToAbstractClassAndAbstractClassImpl2' uses define 'InterfaceToAbstractClassAndAbstractClassImpl' that simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { getInterfaceToAbstractClassAndAbstractClassImpl2AsAny() }

    expectFailure(linkage("Reference to define 'InterfaceToAbstractClass12Impl' can not be evaluated: Expression uses define 'InterfaceToAbstractClass12Impl' that simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { referenceToInterfaceToAbstractClass12Impl() }
    expectFailure(linkage("Reference to define 'InterfaceToAbstractClass12Impl2' can not be evaluated: Expression uses define 'InterfaceToAbstractClass12Impl' (via define 'InterfaceToAbstractClass12Impl2') that simultaneously inherits from 2 classes: 'InterfaceToAbstractClass1', 'InterfaceToAbstractClass2'")) { referenceToInterfaceToAbstractClass12Impl2Impl() }
    expectFailure(linkage("Reference to define 'InterfaceToAbstractClassAndAbstractClassImpl' can not be evaluated: Expression uses define 'InterfaceToAbstractClassAndAbstractClassImpl' that simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { referenceToInterfaceToAbstractClassAndAbstractClassImpl() }
    expectFailure(linkage("Reference to define 'InterfaceToAbstractClassAndAbstractClassImpl2' can not be evaluated: Expression uses define 'InterfaceToAbstractClassAndAbstractClassImpl' (via define 'InterfaceToAbstractClassAndAbstractClassImpl2') that simultaneously inherits from 2 classes: 'AbstractClass', 'InterfaceToAbstractClass1'")) { referenceToInterfaceToAbstractClassAndAbstractClassImpl2Impl() }

    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl1': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl1')")) { removedInterfaceImpl1.abstractFun() }
    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl1': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl1')")) { removedInterfaceImpl1.abstractFunWithDefaultImpl() }
    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl1': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl1')")) { removedInterfaceImpl1.abstractVal }
    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl1': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl1')")) { removedInterfaceImpl1.abstractValWithDefaultImpl }

    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl2': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl2')")) { removedInterfaceImpl2.abstractFun() }
    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl2': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl2')")) { removedInterfaceImpl2.abstractFunWithDefaultImpl() }
    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl2': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl2')")) { removedInterfaceImpl2.abstractVal }
    expectFailure(linkage("Can not read value from variable 'removedInterfaceImpl2': Variable uses unlinked define symbol '/RemovedInterface' (via define 'RemovedInterfaceImpl2')")) { removedInterfaceImpl2.abstractValWithDefaultImpl }

    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl1': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl1')")) { removedAbstractClassImpl1.abstractFun() }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl1': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl1')")) { removedAbstractClassImpl1.openFun() }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl1': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl1')")) { removedAbstractClassImpl1.finalFun() }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl1': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl1')")) { removedAbstractClassImpl1.abstractVal }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl1': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl1')")) { removedAbstractClassImpl1.openVal }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl1': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl1')")) { removedAbstractClassImpl1.finalVal }

    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl2': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl2')")) { removedAbstractClassImpl2.abstractFun() }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl2': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl2')")) { removedAbstractClassImpl2.openFun() }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl2': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl2')")) { removedAbstractClassImpl2.finalFun() }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl2': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl2')")) { removedAbstractClassImpl2.abstractVal }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl2': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl2')")) { removedAbstractClassImpl2.openVal }
    expectFailure(linkage("Can not read value from variable 'removedAbstractClassImpl2': Variable uses unlinked define symbol '/RemovedAbstractClass' (via define 'RemovedAbstractClassImpl2')")) { removedAbstractClassImpl2.finalVal }

    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl1': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl1')")) { removedOpenClassImpl1.openFun() }
    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl1': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl1')")) { removedOpenClassImpl1.finalFun() }
    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl1': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl1')")) { removedOpenClassImpl1.openVal }
    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl1': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl1')")) { removedOpenClassImpl1.finalVal }

    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl2': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl2')")) { removedOpenClassImpl2.openFun() }
    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl2': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl2')")) { removedOpenClassImpl2.finalFun() }
    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl2': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl2')")) { removedOpenClassImpl2.openVal }
    expectFailure(linkage("Can not read value from variable 'removedOpenClassImpl2': Variable uses unlinked define symbol '/RemovedOpenClass' (via define 'RemovedOpenClassImpl2')")) { removedOpenClassImpl2.finalVal }

    expectFailure(linkage("Constructor 'AbstractClassWithChangedConstructorSignature.<init>' can not be called: No constructor found for symbol '/AbstractClassWithChangedConstructorSignature.<init>'")) { AbstractClassWithChangedConstructorSignatureImpl() }
    expectFailure(linkage("Constructor 'OpenClassWithChangedConstructorSignature.<init>' can not be called: No constructor found for symbol '/OpenClassWithChangedConstructorSignature.<init>'")) { OpenClassWithChangedConstructorSignatureImpl() }

    expectSuccess("SuperSuperClassReplacedBySuperClass -> SuperClass -> SuperSuperClass -> Any") { superSuperClassReplacedBySuperClass.inheritsFrom() }
    expectSuccess(true) { SuperSuperClass::define.isInstance(superSuperClassReplacedBySuperClass) } // This check is done during the runtime.
    expectSuccess(true) { SuperClass::define.isInstance(superSuperClassReplacedBySuperClass) } // This check is done during the runtime.

    expectSuccess("SuperClassReplacedBySuperSuperClass -> SuperSuperClass -> Any") { superClassReplacedBySuperSuperClass.inheritsFrom() }
    expectSuccess(true) { SuperSuperClass::define.isInstance(superClassReplacedBySuperSuperClass) } // This check is done during the runtime.
    expectSuccess(false) { SuperClass::define.isInstance(superClassReplacedBySuperSuperClass) } // This check is done during the runtime.
}
