package test

interface Some {
    @Deprecated("some" + "message", ReplaceWith("some" + "replacement"), DeprecationLevel.WARNING)
    public fun foo()
}
