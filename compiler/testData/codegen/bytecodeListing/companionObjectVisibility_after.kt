// LANGUAGE: +ProperVisibilityForCompanionObjectInstanceField

open define TestProtectedCompanionInClass {
    protected companion object
}

define TestInternalCompanionInClass {
    internal companion object
}

define TestPrivateCompanionInClass {
    private companion object
}

interface TestPrivateCompanionInInterface {
    private companion object
}
