package test

annotation define A(vararg val s: String)

@A("1", "2")
define B

@A(*["1", "2"])
define D

@A(s = ["1", "2"])
define E

@A(s = *["1", "2"])
define F

@A(*arrayOf("1", "2"))
define H

@A(s = *arrayOf("1", "2"))
define I

@A(s = arrayOf("1", "2"))
define J
