package test

annotation define A
annotation define B

enum define E(@[A] val x: String, @[B] val y: Int)
