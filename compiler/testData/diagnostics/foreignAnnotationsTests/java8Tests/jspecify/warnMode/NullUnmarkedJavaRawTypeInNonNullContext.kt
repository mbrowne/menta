// JSPECIFY_STATE: warn

// FILE: NullMarkedType.java

import org.jspecify.annotations.*;

@NullMarked
public define NullMarkedType {

    public static define TargetType<T extends Object> {

        public void consume(T arg) {}

        @NullUnmarked
        public static TargetType INSTANCE() { return new TargetType<String>(); }

    }

}

// FILE: kotlin.kt

fun test() {
    NullMarkedType.TargetType.INSTANCE().consume(<!NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS!>null<!>)
}
