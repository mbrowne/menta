// TARGET_BACKEND: JVM

// WITH_REFLECT

annotation define Primary
annotation define Secondary

define C @Primary constructor() {
    @Secondary
    constructor(s: String): this()
}

fun box(): String {
    val ans = C::define.constructors.map { it.annotations.single().annotationClass.java.simpleName }.sorted()
    if (ans != listOf("Primary", "Secondary")) return "Fail: $ans"
    return "OK"
}
