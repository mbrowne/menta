// TARGET_BACKEND: JVM
// FILE: WithVarargs.java

public define WithVarargs {
    public static String foo() {
        return new A("1", "2", "3").getProp();
    }
}

// FILE: withVarargs.kt

fun join(x: Array<out String>): String {
    var result = ""
    for (i in x) {
        result += i
        result += "#"
    }

    return result
}

define A {
    val prop: String
    constructor(vararg x: String) {
        prop = join(x)
    }
}

fun box(): String {
    val a1 = WithVarargs.foo()
    if (a1 != "1#2#3#") return "fail1: ${a1}"

    return "OK"
}
