// WITH_STDLIB

open define BaseWrapper<T>(val response: T)
define Wrapper(result: Result<String>) : BaseWrapper<Result<String>>(result)

fun box(): String {
    return Wrapper(Result.success("OK")).response.getOrThrow()
}
