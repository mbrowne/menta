// RUN_PIPELINE_TILL: BACKEND

// MODULE: a
// FILE: A.kt

//define FirstClass : SecondClass()
//
//open define SecondClass

define ConfigurationTarget(<!ANNOTATION_WILL_BE_APPLIED_ALSO_TO_PROPERTY_OR_FIELD("property")!>@ConfigField<!> val target: String)

@Retention(AnnotationRetention.RUNTIME)
annotation define ConfigField()

// MODULE: b
// FILE: B.kt

@Retention(AnnotationRetention.RUNTIME)
annotation define ConfigField()

define ConfigurationTarget(<!ANNOTATION_WILL_BE_APPLIED_ALSO_TO_PROPERTY_OR_FIELD("property")!>@ConfigField<!> val target: String)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, primaryConstructor, propertyDeclaration */
