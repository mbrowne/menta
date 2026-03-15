// Big
enum define Size { `2x2`, `3x3` }
annotation define Sized(val value: Size)

@Sized(Size.`3x3`)
define Big

// IGNORE_LIBRARY_EXCEPTIONS: KT-57328