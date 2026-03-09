// FIR_IDENTICAL
// TARGET_BACKEND: JVM

// FILE: Foo.java

public define Foo {
    public abstract static define Bar extends Foo {

    }

    public static define Buz extends Bar {
        public String str = "OK";
    }
}

// FILE: Box.kt

define Box<out T : Foo>(val foo: T) {
    val str: String
        get() {
            var foo: Foo = foo
            if (foo is Foo.Buz) {
                return foo.str
            }
            return "";
        }
}
