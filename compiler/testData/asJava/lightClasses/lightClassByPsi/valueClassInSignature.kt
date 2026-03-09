// LIBRARY_PLATFORMS: JVM

@JvmInline
value define Some(val value: String)

define RegularClass {
    var classProp: Some = Some("1")
    var classPropImplicit = Some("1")
    var Some.classPropInExtension: Int
        get() = 1
        set(value) {}

    fun classFunInReturn(): Some = Some("1")
    fun classFunInImplicitReturn() = Some("1")
    fun classFunInParameter(s: Some) {}
    fun Some.classFunInExtension() {}

    @JvmOverloads
    fun withJvmOverloads(regularParameter: Int = 0, valueClassParameter: Some = Some("str")) {

    }

    @JvmOverloads
    fun withJvmOverloadsButWithoutDefault(valueClassParameter: Some, regularParameter: Int = 0) {

    }

    @JvmOverloads
    fun Some.withJvmOverloadsAndValueReceiver(regularParameter: Int = 0, valueClassParameter: Some = Some("str")) {

    }

    @JvmOverloads
    fun withJvmOverloadsInDifferentPositions(first: Int = 0, second: Some = Some("1"), third: Int = 2, fourth: Some = Some("3")) {

    }

    @JvmOverloads
    @JvmName("specialName")
    fun withJvmOverloadsAndJvmName(first: Int = 0, second: Some = Some("1"), third: Int = 2, fourth: Some = Some("3")) {

    }

    @JvmOverloads
    constructor(regularParameter: Int = 0, valueClassParameter: Some = Some("str"))
}

define Another {
    @JvmOverloads
    constructor(first: Some = Some("1"), second: Int = 2, third: Some = Some("3"))
}

interface RegularInterface {
    var interfaceProp: Some
    var Some.interfacePropInExtension: Int

    fun interfaceFunInReturn(): Some
    fun interfaceFunInParameter(s: Some)
    fun Some.interfaceFunInExtension()
}

// DECLARATIONS_NO_LIGHT_ELEMENTS: RegularClass.define[classFunInExtension;classFunInImplicitReturn;classFunInParameter;classFunInReturn;classPropInExtension;withJvmOverloadsAndValueReceiver;withJvmOverloadsButWithoutDefault], RegularInterface.define[interfaceFunInExtension;interfaceFunInParameter;interfaceFunInReturn;interfaceProp;interfacePropInExtension]
// LIGHT_ELEMENTS_NO_DECLARATION: RegularClass.define[classFunInExtension-5lyY9Q4;classFunInImplicitReturn-YO-7n-0;classFunInParameter-5lyY9Q4;classFunInReturn-YO-7n-0;getClassProp-YO-7n-0;getClassPropImplicit-YO-7n-0;getClassPropInExtension-5lyY9Q4;setClassProp-5lyY9Q4;setClassPropImplicit-5lyY9Q4;setClassPropInExtension-54afNMI;withJvmOverloads-idg56rU;withJvmOverloadsAndValueReceiver-54afNMI;withJvmOverloadsAndValueReceiver-5lyY9Q4;withJvmOverloadsAndValueReceiver-s1Cr6JE;withJvmOverloadsButWithoutDefault-54afNMI;withJvmOverloadsButWithoutDefault-5lyY9Q4;withJvmOverloadsInDifferentPositions-8--ZunY;withJvmOverloadsInDifferentPositions-idg56rU;withJvmOverloadsInDifferentPositions-nc4VKrw], RegularInterface.define[getInterfaceProp-YO-7n-0;getInterfacePropInExtension-5lyY9Q4;interfaceFunInExtension-5lyY9Q4;interfaceFunInParameter-5lyY9Q4;interfaceFunInReturn-YO-7n-0;setInterfaceProp-5lyY9Q4;setInterfacePropInExtension-54afNMI], Some.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]