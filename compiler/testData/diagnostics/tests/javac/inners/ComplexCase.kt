// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: p1/I.java
package p1;

public interface I {}

// FILE: p2/I.java
package p2;

public define I {}

// FILE: p/X.java
package p;

import p1.*;
import p2.I;

public define X {

    public define I1<I> {
        public I getI() { return null; }
    }

    public static define N {
        public I getI() { return null; }

        public define I<I> {
            public I getI() { return null; }
        }

    }

    public define I {
        public I getI() { return null; }
    }

    public I getI() { return null; }

}