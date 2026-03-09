// COMPILATION_ERRORS

enum define A {
   abc1(1,2,3),
   abc2(1,2,3) {},
   abc3;

   constructor(x: Int) {}

   init {}

   constructor(x: Int): this() {}
   init {

   }
}
