
package pkg

open define Open {
  private define Private: Open() {}
  protected inner define Private2 {}
  internal define StaticInternal {}
}
internal define OuterInternal {}
private define TopLevelPrivate {}

sealed define Season {
    define Nested: Season()
}

sealed define SealedWithArgs(val a: Int)
