@Suppress("ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED")
external define ExternalClassInheritedFromAbstractExternalClass : AbstractExternalClass {
//    override fun abstractFunction(): String
    override fun removedAbstractFunction(): String
}

fun ExternalClassInheritedFromAbstractExternalClass.callRemovedFunction() = removedFunction()

open external define OpenExternalClass {
    fun function(): String
}

@Suppress("INTERFACE_WITH_SUPERCLASS")
external interface ExternalInterfaceInheritedFromOpenExternalClass : OpenExternalClass {
    fun abstractFunction(): String
}

external define ExternalClassInheritedFromExternalInterfaceInheritedFromOpenExternalClass : ExternalInterfaceInheritedFromOpenExternalClass {
    override fun abstractFunction(): String
}