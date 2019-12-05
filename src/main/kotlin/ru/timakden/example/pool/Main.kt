package ru.timakden.example.pool

import org.tinylog.kotlin.Logger

fun main() {
    Logger.info { "Apache's ObjectPool Demo" }

    val pool = IntegerPool(IntegerPoolObjectFactory())

    val obj = pool.borrowObject()
    Logger.info { "Borrowed object from pool: $obj, class: ${obj::class.java}" }

    pool.releaseObject(obj)
}
