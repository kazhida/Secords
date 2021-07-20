package com.abplus.dxf.models.section

import com.abplus.dxf.models.Entity
import java.util.ArrayList

@Suppress("unused")
class Classes {

    companion object {
        val SECTION_NAME: String = "CLASSES".intern()
    }

    val items: List<Entity> = ArrayList<Entity>()

    override fun toString(): String {
        val builder = StringBuilder();
        builder.append("(${SECTION_NAME} . (")
        for (item in items) builder.append("${item}\n")
        builder.append("))")
        return builder.toString()
    }
}