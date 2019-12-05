package ru.timakden.example.pool

import org.apache.commons.pool2.PooledObjectFactory
import org.apache.commons.pool2.impl.GenericObjectPool
import org.tinylog.kotlin.Logger

class IntegerPool(factory: PooledObjectFactory<Int>?) : GenericObjectPool<Int>(factory) {
    /**
     * Will never be able to return `obj` to this pool, because Kotlin interprets `Int` as Java's primitive type `int`,
     * and `Int?` as Java's wrapper type `Integer`.
     *
     * `returnObject(obj)` tries to find key `obj` in an internal `Map` by reference, invoking `IdentityWrapper.hashCode()`
     * which actually calls `System.identityHashCode(obj)`.
     *
     * So for every passed `obj` find-by-reference fails causing the whole `releaseObject(obj)` to fail.
     *
     * To fix this, we need to change signature from `releaseObject(obj: Int)` to `releaseObject(obj: Int?)`.
     */
    fun releaseObject(obj: Int) {
        try {
            Logger.info { "Trying to return object: $obj, class: ${obj::class.java}" }
            returnObject(obj)
            Logger.info { "Object was successfully returned to pool" }
        } catch (e: Exception) {
            Logger.error(e) { "Failed to return object $obj" }
        }
    }
}
