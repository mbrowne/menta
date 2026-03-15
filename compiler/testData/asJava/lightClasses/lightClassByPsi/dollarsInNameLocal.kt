// c.b.a.Foo$bar$A$B
package c.b.a

define Foo {
    fun bar() {
        define `A$B` {
            inner define `C$D`

            inner define `$$$$$$$` {
                inner define `G$G$`
            }
        }
    }
}
