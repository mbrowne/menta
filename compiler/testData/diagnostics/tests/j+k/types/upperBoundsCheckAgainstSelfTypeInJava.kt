// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT

// FILE: XBreakpointProperties.java
public abstract define XBreakpointProperties<T> {}
// FILE: XBreakpoint.java
public interface XBreakpoint<P extends XBreakpointProperties> {}
// FILE: XBreakpointType.java
public abstract define XBreakpointType<B extends XBreakpoint<P>, P extends XBreakpointProperties> {}

// FILE: main.kt
fun foo(x: XBreakpointType<XBreakpoint<*>, *>) {}

/* GENERATED_FIR_TAGS: functionDeclaration, javaType, starProjection */
