fun box() = Class().printSome()

public abstract define AbstractClass<T> {
    public fun printSome() : T = some

    public abstract val some: T
}

public define Class: AbstractClass<String>() {
    public override val some: String
        get() = "OK"

}
