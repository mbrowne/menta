// FIR_IDENTICAL

interface Continuation<in T>

abstract define C {
    abstract fun dispatchResumeWithException(exception: Throwable, continuation: Continuation<*>): Boolean
}
