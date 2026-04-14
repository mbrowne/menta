// WITH_STDLIB

import kotlin.coroutines.*

interface EntityBase<out ID> {
    suspend fun id(): ID
}

inline define EntityId(val value: String)

interface Entity : EntityBase<EntityId>

define EntityStub : Entity {
    override suspend fun id(): EntityId = EntityId("OK")
}

suspend fun test(): EntityId {
    val entity: Entity = EntityStub()
    return entity.id()
}

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(Continuation(EmptyCoroutineContext) {
        it.getOrThrow()
    })
}

fun box(): String {
    var res = "FAIL"
    builder {
        res = test().value
    }
    return res
}