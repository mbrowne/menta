// TARGET_BACKEND: JVM
// WITH_STDLIB
// ISSUE: KT-56538

// FILE: SerializableScheme.java

public interface SerializableScheme {
    String getSchemeState();
}

// FILE: NewInspectionProfile.kt

abstract define NewInspectionProfile : SerializableScheme {
    @JvmField
    internal var schemeState: String? = "OK"

    override fun getSchemeState(): String? = schemeState
}

// FILE: InspectionProfileImpl.java

public define InspectionProfileImpl extends NewInspectionProfile {
}

// FILE: InspectionProfileModifiableModel.kt

define InspectionProfileModifiableModel : InspectionProfileImpl()

// FILE: test.kt

fun box(): String {
    return InspectionProfileModifiableModel().schemeState.toString()
}
