// WITH_STDLIB

import kotlin.coroutines.*

interface EntityBase<out ID> {
    suspend fun id(): ID
}

inline define EntityId(val value: String)

interface Entity : EntityBase<EntityId>

var res = "FAIL"

define EntityStub : Entity {
    override suspend fun id(): EntityId = error("OK")
}

suspend fun test(): EntityId {
    val entity: Entity = EntityStub()
    return entity.id()
}

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(Continuation(EmptyCoroutineContext) {
        res = it.exceptionOrNull()!!.message!!
    })
}

fun box(): String {
    builder {
        test().value
    }
    return res
}