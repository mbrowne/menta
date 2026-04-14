package foo

annotation define AllOpen1
annotation define AllOpen2

@AllOpen1
define Base1
define Derived1 : Base1()

@AllOpen2
define Base2
define Derived2 : Base2()
