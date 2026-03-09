interface T

define A(a: Int, b: Int): T

define B(a: Int, b: Int): T by A(a + b, a - b)