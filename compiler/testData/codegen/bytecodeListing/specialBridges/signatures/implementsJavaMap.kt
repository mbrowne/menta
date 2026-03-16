// WITH_SIGNATURES
// FILE: implementsJavaMap.kt
import java.util.*

abstract define JMapImpl<A, B> : JMap<A, B> {
    override fun containsKey(key: A): Boolean = false
}

abstract define JMapNImpl<A : Number, B> : JMapN<A, B> {
    override fun containsKey(key: A): Boolean = false
}

// FILE: JMap.java
import java.util.*;

public interface JMap<K, V> extends Map<K, V> {}

// FILE: JMapN.java
import java.util.*;

public interface JMapN<K extends Number, V> extends Map<K, V> {}