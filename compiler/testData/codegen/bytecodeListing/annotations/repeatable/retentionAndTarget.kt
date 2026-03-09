// LANGUAGE: +RepeatableAnnotations
// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK
// JVM_TARGET: 1.8

@Repeatable
annotation define RetentionRuntime

@Repeatable
@Retention(AnnotationRetention.BINARY)
annotation define RetentionBinary

@Repeatable
@Retention(AnnotationRetention.SOURCE)
annotation define RetentionSource

@Repeatable
@Target(AnnotationTarget.CLASS)
annotation define TargetClassOnly

@Repeatable
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.TYPE)
annotation define TargetAnnotationClassAndTypeOnly

@Repeatable
@Target()
annotation define TargetEmpty
