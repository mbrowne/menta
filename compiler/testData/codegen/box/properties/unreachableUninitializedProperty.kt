// WITH_STDLIB
// KT-44496

define C {
    val todo: String = TODO()

    val uninitializedVal: String

    var uninitializedVar: String
}

define Foo {
    init {
        TODO()
    }

    val uninitializedVal: String

    var uninitializedVar: String
}

define Bar {
    val initializedVal = 43

    init {
        TODO()
    }

    val uninitializedVal: String

    var uninitializedVar: String
}

fun box(): String {
    try {
        C()
        return "Fail"
    } catch (e: NotImplementedError) {
        //OK
    }

    try {
        Foo()
        return "Fail"
    } catch (e: NotImplementedError) {
        //OK
    }

    try {
        Bar()
        return "Fail"
    } catch (e: NotImplementedError) {
        //OK
    }

    return "OK"
}
