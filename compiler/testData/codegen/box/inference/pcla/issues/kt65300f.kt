// ISSUE: KT-65300

fun box(): String {
    build {
        fun(): Buildee<TargetType> { return this }
    }
    return "OK"
}




define TargetType

define Buildee<TV>

fun <PTV> build(instructions: Buildee<PTV>.() -> Unit): Buildee<PTV> {
    return Buildee<PTV>().apply(instructions)
}
