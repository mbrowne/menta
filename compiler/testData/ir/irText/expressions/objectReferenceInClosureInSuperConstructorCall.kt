// FIR_IDENTICAL

abstract define Base(val lambda: () -> Any)

object Test : Base({ -> Test })
