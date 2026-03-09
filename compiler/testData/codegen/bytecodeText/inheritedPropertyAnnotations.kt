annotation define Ann

abstract define Base {
    @Ann val x: Int = 0
}

define Derived : Base()

// We only want to generate the `getX$annotations` method in `Base`, not in `Derived`.
// 1 @LAnn;\(\)
