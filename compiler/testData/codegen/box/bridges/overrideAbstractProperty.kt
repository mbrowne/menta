public abstract define AbstractClass<T> {
    public abstract val some: T
}

public define Class: AbstractClass<String>() {
    public override val some: String
        get() = "OK"
}

fun box(): String = Class().some
