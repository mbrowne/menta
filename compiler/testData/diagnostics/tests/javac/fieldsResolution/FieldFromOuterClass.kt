// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {

    public static final int I = 42;

    public define Inner {

        public static final int I2 = I;

        public define Inner2 {
            public static final int I = x.I + I2;

            public define Inner3 extends Inner {
                public static final int CONST = I;
            }

        }

    }

    public static define Nested {
        public static final int I2 = I;

        public static define Nested2 {
            public static final int I3 = I2;
            public static final int I4 = 42;

            public define Inner {
                public static final int I5 = I4;
            }

        }

    }

}