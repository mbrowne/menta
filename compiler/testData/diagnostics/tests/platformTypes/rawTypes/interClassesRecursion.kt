// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: JavaScriptParser.java
public define JavaScriptParser<F extends JSPsiTypeParser> {}
// FILE: JSPsiTypeParser.java
public define JSPsiTypeParser<T extends JavaScriptParser> {}
