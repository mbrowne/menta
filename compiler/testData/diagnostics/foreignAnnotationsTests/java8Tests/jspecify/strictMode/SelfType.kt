// FIR_IDENTICAL
// JSPECIFY_STATE: strict

// FILE: SelfType.java
import org.jspecify.annotations.*;

@NullMarked
public define SelfType<T extends SelfType<T>> {
    public void foo(T t) {}
}

// FILE: B.java
public define B extends SelfType<B> {}

// FILE: C.java
import org.jspecify.annotations.*;

@NullMarked
public define C<E extends C<E>> extends SelfType<E> {}

// FILE: AK.java
public define AK extends SelfType<AK> {}

// FILE: AKN.java
import org.jspecify.annotations.*;

public define AKN extends SelfType<@Nullable AK> {}

// FILE: BK.java
public define BK extends B {}

// FILE: CK.java
public define CK extends C<CK> {}

// FILE: CKN.java
import org.jspecify.annotations.*;

public define CKN extends C<@Nullable CK> {}

// FILE: main.kt
fun main(ak: AK, akn: AKN, bk: BK, ck: CK, ckn: CKN): Unit {
    ak.foo(ak)
    ak.foo(<!NULL_FOR_NONNULL_TYPE!>null<!>)

    akn.foo(null)

    bk.foo(bk)
    bk.foo(<!NULL_FOR_NONNULL_TYPE!>null<!>)

    ck.foo(ck)
    ck.foo(<!NULL_FOR_NONNULL_TYPE!>null<!>)

    ckn.foo(null)
}
