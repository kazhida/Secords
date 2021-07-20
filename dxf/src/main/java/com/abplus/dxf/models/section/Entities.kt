package com.abplus.dxf.models.section

import com.abplus.dxf.models.Entity
import java.util.ArrayList

@Suppress("unused")
class Entities {

    companion object {
        public val SECTION_NAME: String = "CLASSES".intern()
    }

    private val entities = ArrayList<Entity>()
    public fun get(idx: Int): Entity = entities.get(idx)
    public val size: Int get() = entities.size
    public val length: Int get() = size;

    override fun toString(): String {
        val builder = StringBuilder();
        builder.append("(${SECTION_NAME} . (")
        for (entity in entities) builder.append("${entity}\n")
        builder.append("))")
        return builder.toString()
    }
}