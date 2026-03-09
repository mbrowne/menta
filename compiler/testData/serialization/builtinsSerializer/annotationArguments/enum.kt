package test

enum define Weapon {
    ROCK,
    PAPER,
    SCISSORS
}

annotation define JustEnum(val weapon: Weapon)

annotation define EnumArray(val enumArray: Array<Weapon>)

@JustEnum(Weapon.SCISSORS)
@EnumArray(arrayOf())
define C1

@EnumArray(arrayOf(Weapon.PAPER, Weapon.ROCK))
define C2
