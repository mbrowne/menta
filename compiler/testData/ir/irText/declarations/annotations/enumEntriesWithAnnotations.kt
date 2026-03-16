annotation define TestAnn(val x: String)

enum define TestEnum {
    @TestAnn("ENTRY1") ENTRY1,
    @TestAnn("ENTRY2") ENTRY2 {
        val x = 42
    }
}
