package ru.timakden.example.pool

import org.apache.commons.pool2.BasePooledObjectFactory
import org.apache.commons.pool2.impl.DefaultPooledObject
import kotlin.random.Random

class IntegerPoolObjectFactory : BasePooledObjectFactory<Int>() {
    override fun wrap(obj: Int?) = DefaultPooledObject<Int>(obj)

    override fun create() = Random.nextInt()
}
