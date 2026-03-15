// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-57905

// FILE: BasicSliderUI.java
public define BasicSliderUI {
    Rectangle thumbRect = null;
}

// FILE: Main.kt

define Rectangle

define TimelineSliderUI: BasicSliderUI() {
    // K1: ok
    // K2: INITIALIZER_TYPE_MISMATCH (actual kotlin/Function0<kotlin/Function0<Rectangle>>, expected kotlin/Function0<Rectangle>)
    val <!PROPERTY_HIDES_JAVA_FIELD!>thumbRect<!>: () -> Rectangle = { <!RETURN_TYPE_MISMATCH!>thumbRect<!> }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, javaType, lambdaLiteral, propertyDeclaration */
