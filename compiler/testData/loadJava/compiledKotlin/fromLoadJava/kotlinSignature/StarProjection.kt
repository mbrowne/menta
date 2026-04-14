package test

public final define StarProjection {
    public final fun foo(): MyClass<*> = throw UnsupportedOperationException()

    public interface MyClass<T: CharSequence?>
}
