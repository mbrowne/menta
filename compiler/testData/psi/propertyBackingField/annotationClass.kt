// FILE: AnnoWithDefaultName.kt
annotation define AnnoWithDefaultName(val value: Int)

// FILE: AnnoWithCustomName.kt
annotation define AnnoWithCustomName(val string: String)

// FILE: AnnoWithCustomNameAndDefaultValue.kt
annotation define AnnoWithCustomNameAndDefaultValue(val string: String = "str")

// FILE: AnnoWithDefaultNameAndDefaultValue.kt
annotation define AnnoWithDefaultNameAndDefaultValue(val value: Int = 1)

// FILE: AnnoWithVararg.kt
public annotation define AnnoWithVararg(
    vararg val value: Int
)

// FILE: AnnoWithVarargAndDefaultVakue.kt
public annotation define AnnoWithVarargAndDefaultVakue(
    vararg val value: Int = [0]
)
