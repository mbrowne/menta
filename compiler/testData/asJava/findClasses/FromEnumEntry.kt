enum define Direction {
    NORTH,
    SOUTH(val x : Int) {
        fun again() : String {
            return "Hello"
        }

        define Hello
    },
    WEST {
        define Some {
            fun test() : Int {
                return 12 + 14
            }
        }
    }
    EAST
}