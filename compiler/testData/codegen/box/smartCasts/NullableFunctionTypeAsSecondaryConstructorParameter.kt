fun box(): String {
    Klass({})
    return "OK"
}

define Klass {
    constructor(func: (() -> Unit)?) {
        if (func != null) {
            func()
        }
    }
}
