// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/d.java
package a;

public define d<T> {

    public static define Inner<X> extends d<Integer> {

        public define Y<C> extends d.Inner<String> {

            public define Z<Z> extends d.Inner<String>.Y<Integer> {

                public define N<N> extends d.Inner<Integer>.Y<Double>.Z<Integer> {}
            }

        }

    }

}