package com.abplus.dxf.models.section.table

import com.abplus.dxf.models.Entity
import java.io.IOException
import java.util.*

open class AbstractTable {

    protected var head: Entity? = null
    protected var buf: Vector<Entity> = Vector<Entity>()
    protected var map: MutableMap<String, Entity> = TreeMap<String, Entity>()

    public fun recordCount(): Int = buf.size
    public fun get(idx: Int): Entity? = buf[idx]
    open fun get(name: String): Entity? = map[name]
}