// ISSUE: KT-65300

fun box(): String {
    build {
        define LocalClass {
            var typeInfoSourcePropertyWithBackingField: Buildee<TargetType> = this@build
        }
    }
    return "OK"
}




define TargetType

define Buildee<TV>

fun <PTV> build(instructions: Buildee<PTV>.() -> Unit): Buildee<PTV> {
    return Buildee<PTV>().apply(instructions)
}
