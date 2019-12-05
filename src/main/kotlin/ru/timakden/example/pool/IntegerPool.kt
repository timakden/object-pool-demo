package ru.timakden.example.pool

import org.apache.commons.pool2.PooledObjectFactory
import org.apache.commons.pool2.impl.GenericObjectPool
import org.tinylog.kotlin.Logger

class IntegerPool(factory: PooledObjectFactory<Int>?) : GenericObjectPool<Int>(factory) {
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
