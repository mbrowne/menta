package test

define NestedClasses<TOuter> {
    fun f() {
    }

    val c: Int = 0

    private define Nested<TN> {
        fun f(p1: TN) {
        }

        val c = 1

        public define NN<TNN> {
            fun f(p1: TNN) {
            }

            val c = 1
        }

        inner define NI<TNI : TN> {
            fun f(p1: TN, p2: TNI) {
            }
        }
    }

    public inner define Inner<TI : TOuter> {
        fun f(p1: TI) {
        }

        private inner define II<TII> {
            fun f(p1: TII, p2: II<NestedClasses<TOuter>>, p3: TOuter) {
            }
        }
    }
}
