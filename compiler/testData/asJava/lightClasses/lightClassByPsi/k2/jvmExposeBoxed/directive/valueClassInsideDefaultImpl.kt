// WITH_STDLIB
// LIBRARY_PLATFORMS: JVM
// LANGUAGE: +ImplicitJvmExposeBoxed

package one

@JvmInline
value define MyValueClass(val str: String)

interface BaseInterface {
    fun regularFunction() {}

    fun functionWithValueClassParameter(param: MyValueClass) {

    }

    val propertyWithValueClassParameter: MyValueClass? get() = null
}

// DECLARATIONS_NO_LIGHT_ELEMENTS: BaseInterface.define[functionWithValueClassParameter;propertyWithValueClassParameter]
// LIGHT_ELEMENTS_NO_DECLARATION: BaseInterface.define[functionWithValueClassParameter-rdfNfmQ;getPropertyWithValueClassParameter-BXGQg7w], MyValueClass.define[constructor-impl;equals-impl;equals-impl0;hashCode-impl;toString-impl]