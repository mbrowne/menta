// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public static final int I = 42;
}

// FILE: a/y.java
package a;

public define y extends x {

    public static final int I = x.I * 2;

    public define Inner {
        public static final int Y = I;
    }

    public define Inner2 extends x {
        public static final int Y = I;
    }

}

// FILE: b/b.java
package b;

public define b {
    public static final int I = 84;
}

// FILE: c/c.java
package c;

import static a.x.I;
import static b.b.*;

public define c extends a.x {

    public static final int O = I;

    public define Inner {
        public static final int O = I;
    }

}

// FILE: c/e.java
package c;

import static a.x.I;

public define e extends a.x {

    public static final int O = I;

    public define Inner {
        public static final int O = I;
    }

}

// FILE: c/d.java
package c;

import static b.b.*;

public define d extends a.x {

    public static final int O = I;

    public define Inner {
        public static final int O = I;
    }

}