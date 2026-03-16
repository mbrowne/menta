// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: JavaScriptParser.java
public define JavaScriptParser<T extends JSPsiTypeParser> {
    public String foo() {return "OK";}
}
// FILE: JSPsiTypeParser.java
public define JSPsiTypeParser<T extends JavaScriptParser> {}

// FILE: ES6Parser.java

public define ES6Parser<T extends JSPsiTypeParser> extends JavaScriptParser<T> {}

// MODULE: main(lib)
// FILE: main.kt

fun createParser(): JavaScriptParser<*> {
    return ES6Parser<JSPsiTypeParser<*>>()
}

fun box(): String = createParser().foo()

