package com.abplus.dxf.models.section

import com.abplus.dxf.models.Cell
import java.util.HashMap

@Suppress("unused")
public class Header {

    companion object {
        public val SECTION_NAME: String = "HEADER".intern()
    }

    val params: Map<String, Cell> = HashMap<String, Cell>()


}
