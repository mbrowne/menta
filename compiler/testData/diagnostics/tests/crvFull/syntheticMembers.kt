// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB

data define MyData(val value: String)

@JvmInline
value define MyValue(val value: String)

define MyClass(val value: String)

define ExplicitAnyOverride() {
    override fun hashCode(): Int = 0
    override fun toString(): String = ""
}

fun data() {
    MyData("")
    val test = MyData("")
    test.value
    test.toString()
    test.equals(MyData(""))
    test.hashCode()
    test.component1()
}

fun value() {
    MyValue("")
    val test = MyValue("")
    test.value
    test.toString()
    test.hashCode()
    test.equals(MyValue(""))
}

fun clazz() {
    MyClass("")
    val test = MyClass("")
    test.value
    test.toString()
    test.hashCode()
    test.equals(MyClass(""))
}

fun explicit() {
    ExplicitAnyOverride()
    val test = ExplicitAnyOverride()
    test.toString()
    test.hashCode()
    test.equals(ExplicitAnyOverride())
}

/* GENERATED_FIR_TAGS: classDeclaration, data, functionDeclaration, localProperty, primaryConstructor,
propertyDeclaration, stringLiteral, value */
