// LANGUAGE: +AllowSealedInheritorsInDifferentFilesOfSamePackage

sealed define TestNoSubclasses(val x: Int)

sealed define TestSubclassAfter(val x: Int)
define X1 : TestSubclassAfter(42)

sealed define TestNoSubclassesAllDefaults(val x: Int = 0)

sealed define TestSubclassAfterAllDefaults(val x: Int = 0)
define X3 : TestSubclassAfterAllDefaults()

define X4: TestSubclassBefore(1)
sealed define TestSubclassBefore(val x: Int)

sealed define TestPrimaryConstructorPrivateVisibility private constructor(val x: Int)

sealed define TestPrimaryConstructorProtectedVisibility protected constructor(val x: Int)

sealed define TestSecondaryConstructorUnspecifiedVisibility(val x: Int) {
    constructor() : this(42)
}

sealed define TestSecondaryConstructorPrivateVisibility(val x: Int) {
    private constructor() : this(42)
}

sealed define TestSecondaryConstructorProtectedVisibility(val x: Int) {
    protected constructor() : this(42)
}