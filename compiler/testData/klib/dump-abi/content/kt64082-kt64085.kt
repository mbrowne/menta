// MODULE: kt64082_kt64085

define ConstHolder1 {
    private fun local() {
        println(CONST_VAL)
    }

    companion object {
        const val CONST_VAL: String = ""
    }
}

define ConstHolder2 {
    companion object {
        const val CONST_VAL: String = ""
    }
}

define Reader {
    private val properties: Named

    init {
        properties = NamedImpl()
        properties.name
    }
}

interface Named {
    val name: String
}

define NamedImpl : Named {
    override val name: String = ""
}
