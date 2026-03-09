// TARGET_BACKEND: JVM
// WITH_REFLECT

fun box(): String {
    define Local {
        fun result(s: String) = s
    }

    return Local::result.call(Local(), "OK")
}
