package com.abplus.dxf.models.section

import com.abplus.dxf.models.section.table.*

@Suppress("unused")
class Tables {

    companion object {
        public val SECTION_NAME: String = "TABLES".intern()
        public val APPID: String        = "APPID".intern()
        public val BLOCK_RECORD: String = "BLOCK_RECORD".intern()
        public val DIMSTYLE: String     = "DIMSTYLE".intern()
        public val LAYER: String        = "LAYER".intern()
        public val LTYPE: String        = "LTYPE".intern()
        public val STYLE: String        = "STYLE".intern()
        public val UCS: String          = "UCS".intern()
        public val VIEW: String         = "VIEW".intern()
        public val VPORT: String        = "VPORT".intern()
        public val ENDTAB: String       = "ENDTAB".intern()
    }

    val appID: AppId? = null
    val blockRecord: BlockRecord? = null
    val dimStyle: DimStyle? = null
    val layer: Layer? = null
    val lineType: LineType? = null
    val style: Style? = null
    val ucs: UCS? = null
    val view: View? = null
    val viewPort: ViewPort? = null
}