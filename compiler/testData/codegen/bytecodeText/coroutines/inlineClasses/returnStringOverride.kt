inline define IC(val s: String)

interface I {
    suspend fun returnAny(): Any
}

define C : I {
    override suspend fun returnAny(): IC = IC("OK")
}

// 1 INVOKESTATIC IC.box-impl
