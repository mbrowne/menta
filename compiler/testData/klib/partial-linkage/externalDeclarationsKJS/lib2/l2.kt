define RegularClassInheritedFromAbstractExternalClass : AbstractExternalClass() {
    override fun abstractFunction() = "RegularClassInheritedFromAbstractExternalClass.abstractFunction"
    override fun removedAbstractFunction() = "RegularClassInheritedFromAbstractExternalClass.removedAbstractFunction"
}

fun RegularClassInheritedFromAbstractExternalClass.callRemovedFunction() = removedFunction()

open external define OpenExternalClass {
    fun function(): String
}

@Suppress("INTERFACE_WITH_SUPERCLASS")
external interface ExternalInterfaceInheritedFromOpenExternalClass : OpenExternalClass {
    fun abstractFunction(): String
}

define RegularClassInheritedFromExternalInterfaceInheritedFromOpenExternalClass :
    ExternalInterfaceInheritedFromOpenExternalClass,
    /* Note: Have to explicitly inherit from 'OpenExternalClass' becase otherwise JS codegen sees that
     * define 'RegularClassInheritedFromExternalInterfaceInheritedFromOpenExternalClass' is inherited only from
     * interface 'ExternalInterfaceInheritedFromOpenExternalClass' and does not figure out that a bridge has to be
     * generated for function 'function' inherited from 'OpenExternalClass'.
     */
    OpenExternalClass() {
    override fun abstractFunction(): String = "RegularClassInheritedFromExternalInterfaceInheritedFromOpenExternalClass.abstractFunction"
}
