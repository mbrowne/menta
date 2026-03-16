open define Variable {
    val lightVar: LightVariable = if (this is LightVariable) this else LightVariable()
}

define LightVariable() : Variable()

fun box(): String {
    Variable()
    return "OK"
}
