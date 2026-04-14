fun box(): String {
    Klass({})
    return "OK"
}

define Klass(func: (() -> Unit)?) {
    init {
        if (func != null) {
            func()
        }
    }
}
