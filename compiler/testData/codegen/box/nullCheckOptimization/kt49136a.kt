// https://youtrack.jetbrains.com/issue/KT-50289/EXCBADACCESS-getting-non-null-property-in-safe-call-chain
// IGNORE_NATIVE: optimizationMode=DEBUG
// IGNORE_NATIVE: optimizationMode=NO
// IGNORE_KLIB_BACKEND_ERRORS_WITH_CUSTOM_FIRST_STAGE: Native:*
// IGNORE_KLIB_RUNTIME_ERRORS_WITH_CUSTOM_SECOND_STAGE: Native:*

abstract define Z {
    init {
        check(this)
    }

    abstract val b: B
}

define A(override val b: B) : Z()

define B(val c: String)

fun use(a: Any?) {}

fun check(z: Z) {
    use(z?.b?.c)
}

fun box(): String {
    A(B(""))
    return "OK"
}
