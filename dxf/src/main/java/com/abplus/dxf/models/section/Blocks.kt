package com.abplus.dxf.models.section

import com.abplus.dxf.models.Entity

public data class Blocks(
    val blocks: Map<String, Item> = HashMap(),
    val names: List<String> = ArrayList()
) {

    companion object {
        public const val SECTION_NAME: String = "BLOCKS"
        public const val ENDBLK: String = "ENDBLK"
    }

    public fun add(block: Item): Item? {
        val name = block.head.name
        return if (name != null) {
            (names as? MutableList)?.add(name)
            (blocks as? MutableMap)?.put(name, block)
        } else {
            null
        }
    }

    public fun add(
        head: Entity,
        entities: List<Entity>,
        tail: Entity
    ): Item? = add(Item(head, entities, tail))

    override fun toString(): String {
        val builder = StringBuilder();
        builder.append("(${SECTION_NAME} . (\n")
        for (name in names) builder.append("(${blocks[name]})\n")
        builder.append("))")
        return builder.toString()
    }

    public data class Item(
        val head: Entity,
        val entities: List<Entity>,
        val tail: Entity
        ) {
        val length: Int get() = entities.size

        override fun toString(): String {
            val builder = StringBuilder()
            builder.append("${head}\n")
            for (entity in entities) builder.append("${entity}\n")
            builder.append("${tail}\n")
            return builder.toString()
        }
    }

    public class Builder() {

    }
}