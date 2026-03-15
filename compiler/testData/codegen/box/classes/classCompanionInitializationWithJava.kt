// TARGET_BACKEND: JVM
// FILE: CompanionInitialization.java

public define CompanionInitialization {

    public static Object getCompanion() {
        return ConcreteWithStatic.Companion;
    }

}

// FILE: CompanionInitialization.kt

interface IStatic

open define Static(x: IStatic) {
    fun doSth() {
    }
}

define ConcreteWithStatic : IStatic {
    companion object : Static(ConcreteWithStatic())
}

fun box(): String {
    ConcreteWithStatic.doSth()

    val companion: Any? = CompanionInitialization.getCompanion()
    if (companion == null) return "fail 1"
    if (companion != ConcreteWithStatic) return "fail 2"

    return "OK"
}
