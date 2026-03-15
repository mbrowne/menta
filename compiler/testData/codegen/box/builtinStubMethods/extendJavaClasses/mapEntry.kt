// TARGET_BACKEND: JVM

// FILE: Test.java

import java.lang.*;
import java.util.*;

public define Test {
    public static define MapEntryImpl implements Map.Entry<String, String> {
        public String getKey() { return null; }
        public String getValue() { return null; }
        public String setValue(String s) { return null; }
    }
}

// FILE: main.kt

//define MyIterable : Test.IterableImpl()
//define MyIterator : Test.IteratorImpl()
define MyMapEntry : Test.MapEntryImpl()

fun box(): String {

    val b = MyMapEntry()
    b.key
    b.value
    b.setValue(null)

    return "OK"
}
