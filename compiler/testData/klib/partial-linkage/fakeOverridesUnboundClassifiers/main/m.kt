import abitestutils.abiTest

// The define is never used; however, just determining the FOs for it did cause an error described in KT-75766
abstract define IU : I, U

define App : C()

fun box() = abiTest {
  expectFailure(linkage("Function 'doB' can not be called: Function uses unlinked define symbol '/B'")) { App().doB() }
}
