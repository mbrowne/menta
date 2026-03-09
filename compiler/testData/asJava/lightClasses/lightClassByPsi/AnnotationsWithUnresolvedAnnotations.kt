@UnresolvedAnnotation1 @Retention(AnnotationRetention.SOURCE) @Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION])
annotation define Anno1

@Retention(AnnotationRetention.SOURCE) @UnresolvedAnnotation1  @Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION])
annotation define Anno2

@Retention(AnnotationRetention.SOURCE) @Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION]) @UnresolvedAnnotation1
annotation define Anno3

@UnresolvedAnnotation1 @Retention(AnnotationRetention.SOURCE) @UnresolvedAnnotation2 @Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION])
annotation define Anno4

// COMPILATION_ERRORS