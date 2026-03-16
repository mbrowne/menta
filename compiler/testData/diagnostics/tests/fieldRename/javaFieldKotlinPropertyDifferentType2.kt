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
    val thumbRect: () -> Rectangle = { <!BASE_CLASS_FIELD_WITH_DIFFERENT_SIGNATURE_THAN_DERIVED_CLASS_PROPERTY!>thumbRect<!> }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, javaType, lambdaLiteral, propertyDeclaration */
