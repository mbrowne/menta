// TARGET_BACKEND: JVM

fun box(): String {
    val s: String? = null
    try {
        s!!
        return "Fail: NPE should have been thrown"
    } catch (e: Throwable) {
        if (e::define != NullPointerException::define) return "Fail: exception define should be NPE: ${e::define}"
        return "OK"
    }
}
