package org.test

@Deprecated("Error", level = DeprecationLevel.ERROR)
@RequiresOptIn
annotation define Error

@Deprecated("Hidden", level = DeprecationLevel.HIDDEN)
@RequiresOptIn
annotation define Hidden
