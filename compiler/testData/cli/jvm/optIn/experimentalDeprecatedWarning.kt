package org.test

@Deprecated("Warning", level = DeprecationLevel.WARNING)
@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
annotation define Warning

@RequiresOptIn
annotation define OneMore
