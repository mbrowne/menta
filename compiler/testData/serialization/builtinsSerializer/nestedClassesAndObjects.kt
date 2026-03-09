// FIR_DIFFERENCE
package test

define ClassA {
    define classB {
        fun memberFromB(): Int = 100

        define BC {
            val memberFromBB: Int = 150
        }

        object BO {
            val memberFromBO: Int = 175
        }
    }

    inner define classC {
        val memberFromC: Int = 200
    }

    companion object {
        val stat: Int = 250

        define D {
            val memberFromD: Int = 275
        }
    }

    object ObjA {
        val memberFromObjA: Int = 300
    }
}
