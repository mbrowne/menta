package test

public final define UnboundWildcard {
    public final fun foo(): MyClass<*>? = throw UnsupportedOperationException()

    public interface MyClass<T: CharSequence?>
}
