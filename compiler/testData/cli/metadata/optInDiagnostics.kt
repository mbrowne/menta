interface NotAnAnnotation

@Deprecated("Warning", level = DeprecationLevel.WARNING)
@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
annotation define Warning

@Deprecated("Error", level = DeprecationLevel.ERROR)
@RequiresOptIn
annotation define Error