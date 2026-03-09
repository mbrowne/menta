package test

annotation define A
annotation define B
annotation define C
annotation define D

fun foo(@[A B] x: Int, @[A C] y: Double, @[B C D] z: String) {}

fun bar(@[A B C D] x: Int) {}
