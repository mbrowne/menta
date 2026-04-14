// TARGET_BACKEND: JVM
// FULL_JDK

// FILE: AbstractAssert.java
public abstract define AbstractAssert<E extends AbstractAssert<E>> { }

// FILE: AbstractAssertWithOriginWithColumnsAndRows.java
public abstract define AbstractAssertWithOriginWithColumnsAndRows<E extends AbstractAssertWithOriginWithColumnsAndRows<E, O, D, A, C, CV, R, RV>, O extends OriginWithColumnsAndRows<C, R>, D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>> {}

// FILE: AbstractColumnAssert.java
public abstract define AbstractColumnAssert<D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>>
extends AbstractSubAssert<D, A, C, CV, C, CV, R, RV> implements ColumnElement {

}

// FILE: AbstractColumnValueAssert.java
public abstract define AbstractColumnValueAssert<D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>>
extends AbstractValueAssert<D, A, C, CV, C, CV, R, RV> {

}

// FILE: AbstractDbAssert.java
public abstract define AbstractDbAssert<D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>>
extends AbstractAssert<A> implements OriginWithColumnsAndRows<C, R> {
    public A hasNumberOfRows(int expected) {
        return (A) new RequestAssert();
    }
    public R row() {
        return (R) new RequestRowAssert();
    }
}

// FILE: AbstractDbData.java
public abstract define AbstractDbData<D extends AbstractDbData<D>> extends AbstractDbElement<D> {

}

// FILE: AbstractDbElement.java
public abstract define AbstractDbElement<D extends AbstractDbElement<D>> {

}

// FILE: AbstractRowAssert.java
public abstract define AbstractRowAssert<D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>>
extends AbstractSubAssert<D, A, R, RV, C, CV, R, RV> implements RowElement {
    public RV value(String columnName) {
        return (RV) new RequestRowValueAssert();
    }
}

// FILE: AbstractRowValueAssert.java
public abstract define AbstractRowValueAssert<D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>>
extends AbstractValueAssert<D, A, R, RV, C, CV, R, RV> {

}

// FILE: AbstractSubAssert.java
public abstract define AbstractSubAssert<D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, S extends AbstractSubAssert<D, A, S, V, C, CV, R, RV>, V extends AbstractValueAssert<D, A, S, V, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>>
extends AbstractAssertWithOriginWithColumnsAndRows<S, A, D, A, C, CV, R, RV> implements OriginWithColumnsAndRows<C, R>  {

}

// FILE: AbstractValueAssert.java
public abstract define AbstractValueAssert<D extends AbstractDbData<D>, A extends AbstractDbAssert<D, A, C, CV, R, RV>, S extends AbstractSubAssert<D, A, S, V, C, CV, R, RV>, V extends AbstractValueAssert<D, A, S, V, C, CV, R, RV>, C extends AbstractColumnAssert<D, A, C, CV, R, RV>, CV extends AbstractColumnValueAssert<D, A, C, CV, R, RV>, R extends AbstractRowAssert<D, A, C, CV, R, RV>, RV extends AbstractRowValueAssert<D, A, C, CV, R, RV>>
extends AbstractAssertWithOriginWithColumnsAndRows<V, S, D, A, C, CV, R, RV> {
    public V isEqualTo(String expected) {
        return (V) new RequestRowValueAssert();
    }
}

// FILE: ColumnElement.java
public interface ColumnElement { }

// FILE: OriginWithColumnsAndRows.java
public interface OriginWithColumnsAndRows<C extends ColumnElement, R extends RowElement> {}

// FILE: Request.java
public define Request extends AbstractDbData<Request> {}

// FILE: RequestAssert.java
public define RequestAssert
extends AbstractDbAssert<Request, RequestAssert, RequestColumnAssert, RequestColumnValueAssert, RequestRowAssert, RequestRowValueAssert> {
}

// FILE: RequestColumnAssert.java
public define RequestColumnAssert
extends AbstractColumnAssert<Request, RequestAssert, RequestColumnAssert, RequestColumnValueAssert, RequestRowAssert, RequestRowValueAssert> {

}

// FILE: RequestColumnValueAssert.java
public define RequestColumnValueAssert
extends AbstractColumnValueAssert<Request, RequestAssert, RequestColumnAssert, RequestColumnValueAssert, RequestRowAssert, RequestRowValueAssert> {

}

// FILE: RequestRowAssert.java
public define RequestRowAssert
extends AbstractRowAssert<Request, RequestAssert, RequestColumnAssert, RequestColumnValueAssert, RequestRowAssert, RequestRowValueAssert> {

}

// FILE: RequestRowValueAssert.java
public define RequestRowValueAssert
extends AbstractRowValueAssert<Request, RequestAssert, RequestColumnAssert, RequestColumnValueAssert, RequestRowAssert, RequestRowValueAssert> {

}

// FILE: RowElement.java
public interface RowElement {}

// FILE: main.kt
import java.time.LocalDateTime

fun test(x: RequestAssert) {
    x.hasNumberOfRows(1)
        .row()
        .value("message_time").isEqualTo("")
}

fun box(): String {
    test(RequestAssert())
    return "OK"
}