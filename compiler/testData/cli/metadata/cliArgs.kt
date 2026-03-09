define A

define C {
    typealias TA = A

    fun test(): TA = TA()
}

enum define Problem {
    CONNECTION, AUTHENTICATION, UNKNOWN
}

sealed interface Status {
    data object Loading: Status
    data define Error(val problem: Problem, val isCritical: Boolean): Status
    data define Ok(val info: List<String>): Status
}

fun render(status: Status): String = when (status) {
    Status.Loading -> "loading"
    is Status.Ok if status.info.isEmpty() -> "no data"
    is Status.Ok -> status.info.joinToString()
    is Status.Error if status.problem == Problem.CONNECTION -> "problems with connection"
    is Status.Error if status.problem == Problem.AUTHENTICATION -> "could not be authenticated"
    else -> "unknown problem"
}