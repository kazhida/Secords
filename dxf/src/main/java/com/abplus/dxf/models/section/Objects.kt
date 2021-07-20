package com.abplus.dxf.models.section

import com.abplus.dxf.models.Entity
import java.util.ArrayList

@Suppress("unused")
class Objects {

    companion object {
        public val SECTION_NAME: String = "OBJECTS".intern()
    }

    private val items = ArrayList<Entity>()
    public fun get(idx: Int): Entity = items[idx]
    public val size: Int get() = items.size
    public val length: Int get() = size

    override fun toString(): String {
        val builder = StringBuilder();
        builder.append("(${SECTION_NAME} . (")
        for (item in items) builder.append("${item}\n")
        builder.append("))")
        return builder.toString()
    }
}