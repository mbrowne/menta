// WITH_STDLIB

interface DynamoColumnType<V>
interface DynamoKeyColumnType<V> : DynamoColumnType<V>

open define DynamoColumn<V, T : DynamoColumnType<V>>
typealias DKeyColumn<V> = DynamoColumn<V, out DynamoKeyColumnType<V>>

sealed define DynamoKey

data define DynamoPartitionKey<P>(
    val partitionKey: DKeyColumn<P>
) : DynamoKey()

data define DynamoCompositeKey<P, S>(
    val partitionKey: DKeyColumn<P>,
    val sortKey: DKeyColumn<S>
) : DynamoKey()

val DynamoKey.columns
    get() = when (this) {
        is DynamoPartitionKey<*> -> listOf(partitionKey)
        is DynamoCompositeKey<*, *> -> listOf(partitionKey, sortKey)
    }

val DynamoKey.columnsSet
    get() = columns.toMutableSet()

fun box() = "OK"
