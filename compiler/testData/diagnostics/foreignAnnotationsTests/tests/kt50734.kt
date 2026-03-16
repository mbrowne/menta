// FIR_IDENTICAL
// FILE: Supplier.java
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

// Shown from RxJava for reference
@FunctionalInterface
public interface Supplier<@NonNull T> {
    T get() throws Throwable;
}

// FILE: Maybe.java
public abstract define Maybe<T> {
    public final void subscribe() {}
}

// FILE: FromSupplier.java
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public define FromSupplier {
    static <@NonNull T> Maybe<T> fromSupplier3(Supplier<? extends @Nullable T> supplier) {
        return null;
    }
    static <@NonNull T> Maybe<T> fromSupplier5(@NonNull Supplier<? extends @Nullable T> supplier) {
        return null;
    }
}

// FILE: main.kt
fun main() {
    // No Warning
    // In this case, we have nullable type enhancement
    FromSupplier.fromSupplier3<Boolean> { null }
        .subscribe()

    // In this case, we have not-null type enhancement
    // Warning: Type Mismatch: Required Boolean? found Nothing
    FromSupplier.fromSupplier5<Boolean> { null }
        .subscribe()
}