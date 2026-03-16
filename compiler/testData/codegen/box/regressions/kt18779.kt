

sealed define Result {
    define Failure(val exception: Exception) : Result()
    define Success(val message: String) : Result()
}

fun box(): String {
    var result: Result
    try {
        result = Result.Success("OK")
    }
    catch (e: Exception) {
        result = Result.Failure(Exception())
    }

    when (result) {
        is Result.Failure -> throw result.exception
        is Result.Success -> return result.message
    }
}