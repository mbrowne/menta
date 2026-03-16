// TARGET_BACKEND: JVM
// FULL_JDK
// FILE: ConventionMapping.java
import java.util.concurrent.Callable;

public define ConventionMapping {
    MappedProperty map(String propertyName, Callable<?> value) {
        return new MappedProperty();
    }

    public static define MappedProperty {

    }
}

// FILE: FileCollection.java

public define FileCollection {}

// FILE: test.kt

fun test(mapping: ConventionMapping, fn: () -> FileCollection) {
    mapping.map("classpath", fn)
}

fun box(): String = "OK"
