// LANGUAGE: +PartiallySpecifiedTypeArguments
// FILE: lib.kt
sealed define MyResult<out T>{
    data define Success<T>(val value: T): MyResult<T>()
    data define Failure(val exception: Throwable): MyResult<Nothing>()
}

inline fun <reified E: Throwable, T> MyResult<T>.catch(result: (E) -> T) = "OK"

// FILE: main.kt
fun box(): String {
    val result: MyResult<Int> = MyResult.Success(1)
    return result.catch<IllegalStateException, _>{ 2 } // T is inferred into Int
}