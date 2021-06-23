package com.abplus.dxf.models

/**
 * # Cell
 *
 * AutoLISPのコンス・セルに相当するクラス
 *
 */
@Suppress("unused")
data class Cell(
    val groupCode: GroupCodes,
    val raw: String
) {
    val asString: String get() = raw
    val asShort: Short? get() = raw.toShortOrNull()
    val asInt: Int? get() = raw.toIntOrNull()
    val asLong: Long? get() = raw.toLongOrNull()
    val asFloat: Float? get() = raw.toFloatOrNull()
    val asDouble: Double? get() = raw.toDoubleOrNull()

    /**
     * AutoLISPで使用されているグループコード（の一部）
     * 必要そうなものだけ定義してある
     */

    enum class GroupCodes(private val value: Int) {
        APP_PERSISTENT_REACTOR_CHAIN(-5),
        APP_CONDITIONAL_OPERATOR(-4),
        APP_XDATA_SENTINEL(-3),
        APP_ENTITY_NAME_REFERENCE(-2),
        APP_ENTITY_NAME(-1),
        TYPE(0),
        TEXT(1),
        NAME(2),
        NAME1(3),
        NAME2(4),
        HANDLE(5),
        LINE_TYPE_NAME(6),
        TEXT_STYLE_NAME(7),
        LAYER_NAME(8),
        VARIABLE_NAME_IDENTIFIER(9),   //  (used only in HEADER section of the DXF file)
        POINT_X(10),
        POINT_X1(11),
        POINT_X2(12),
        POINT_X3(13),
        POINT_X4(14),
        POINT_X5(15),
        POINT_X6(16),
        POINT_X7(17),
        POINT_X8(18),
        //  19 is not used
        POINT_Y(20),
        POINT_Y1(21),
        POINT_Y2(22),
        POINT_Y3(23),
        POINT_Y4(24),
        POINT_Y5(25),
        POINT_Y6(26),
        POINT_Y7(27),
        POINT_Y8(28),
        //  29 is not used
        POINT_Z(30),
        POINT_Z1(31),
        POINT_Z2(32),
        POINT_Z3(33),
        POINT_Z4(34),
        POINT_Z5(35),
        POINT_Z6(36),
        POINT_Z7(37),
        POINT_Z8(38),   // DXF: entity's elevation if nonzero
        ENTITY_THICKNESS(39),
        DOUBLE_PRECISION_VALUE0(40),
        DOUBLE_PRECISION_VALUE1(41),
        DOUBLE_PRECISION_VALUE2(42),
        DOUBLE_PRECISION_VALUE3(43),
        DOUBLE_PRECISION_VALUE4(44),
        DOUBLE_PRECISION_VALUE5(45),
        DOUBLE_PRECISION_VALUE6(46),
        DOUBLE_PRECISION_VALUE7(47),
        DOUBLE_PRECISION_VALUE8(48),    //Linetype scale; double precision floating point scalar value; default value is defined for all entity types
        REPEATED_DOUBLE_PRECISION_VALUE(49),
        ANGLE0(50),
        ANGLE1(51),
        ANGLE2(52),
        ANGLE3(53),
        ANGLE4(54),
        ANGLE5(55),
        ANGLE6(56),
        ANGLE7(57),
        ANGLE8(58),
        //  59 is not used
        ENTITY_VISIBILITY(60),
        //  61 is not used
        COLOR_NUMBER(62),
        //  63-65 is not used
        ENTITY_FOLLOW_FLAG(66),
        MODEL_OR_PAPER_SPACE(67),
        APP_IDENTIFIES_WHETHER_VIEWPORT_IS_ON_BUT_FULLY_OFF_SCREEN(68),
        APP_VIEWPORT_IDENTIFICATION_NUMBER(69),
        INTEGER_VALUE0(70),
        INTEGER_VALUE1(71),
        INTEGER_VALUE2(72),
        INTEGER_VALUE3(73),
        INTEGER_VALUE4(74),
        INTEGER_VALUE5(75),
        INTEGER_VALUE6(76),
        INTEGER_VALUE7(77),
        INTEGER_VALUE8(78),
        // 79-89 is not used
        INT32_VALUE0(90),
        INT32_VALUE1(91),
        INT32_VALUE2(92),
        INT32_VALUE3(93),
        INT32_VALUE4(94),
        INT32_VALUE5(95),
        INT32_VALUE6(96),
        INT32_VALUE7(97),
        INT32_VALUE8(98),
        INT32_VALUE9(99),
        SUBCLASS_DATA_MARKER(100),
        //  101 is not used
        CONTROL_STRINGS(102),
        //  103-104 is not used
        OBJECT_HANDLE(105),
        //  106-109 is not used
        UCS_ORIGIN(110),
        UCS_ORIGIN_X(111),
        UCS_ORIGIN_Y(112),
        // 113-119 is not used
        UCS_ORIGIN2(120),
        UCS_ORIGIN_X2(121),
        UCS_ORIGIN_Y2(122),
        UCS_ORIGIN3(130),
        UCS_ORIGIN_X3(131),
        UCS_ORIGIN_Y3(132),
        //  133-139 is not used
        DOUBLE_PRECISION_VALUE10(140),
        DOUBLE_PRECISION_VALUE11(141),
        DOUBLE_PRECISION_VALUE12(142),
        DOUBLE_PRECISION_VALUE13(143),
        DOUBLE_PRECISION_VALUE14(144),
        DOUBLE_PRECISION_VALUE15(145),
        DOUBLE_PRECISION_VALUE16(146),
        DOUBLE_PRECISION_VALUE17(147),
        DOUBLE_PRECISION_VALUE18(148),
        DOUBLE_PRECISION_VALUE19(149),
        //  150-169 is not used
        INT16_VALUE10(170),
        INT16_VALUE11(171),
        INT16_VALUE12(172),
        INT16_VALUE13(173),
        INT16_VALUE14(174),
        INT16_VALUE15(175),
        INT16_VALUE16(176),
        INT16_VALUE17(177),
        INT16_VALUE18(178),
        INT16_VALUE19(179),
        //  180-209 is not used
        EXTRUSION_DIRECTION_X(210),
        //  211-219 is not used
        EXTRUSION_DIRECTION_Y(220),
        //  221-229 is not used
        EXTRUSION_DIRECTION_Z(230);
        //  このあとも拡張されているのだけど、とりあえず無視しておく

        /**
         * 数値からグループコードを求めるメソッド
         */
        fun findByValue(value: Int): GroupCodes? = values().find { it.value == value }
    }
}


/*
Group codes by number
-5  APP: persistent reactor chain
-4  APP: conditional operator (used only with ssget)
-3  APP: extended data (XDATA) sentinel (fixed)
-2  APP: entity name reference (fixed)
-1  APP: entity name. The name changes each time a drawing is opened. It is never saved (fixed)
 0  Text string indicating the entity type (fixed)
 1  Primary text value for an entity
 2  Name (attribute tag, block name, and so on)
3-4  Other text or name values
 5  Entity handle; text string of up to 16 hexadecimal digits (fixed)
 6  Linetype name (fixed)
 7  Text style name (fixed)
 8  Layer name (fixed)
 9  DXF: variable name identifier (used only in HEADER section of the DXF file)
10(20,30)  Primary point; this is the start point of a line or text entity, center of a circle, and so on DXF: X value of the primary point (followed by Y and Z value codes 20 and 30)
11-18(21-28,31-38)  Other points APP: 3D point (list of three reals)DXF: X value of other points (followed by Y value codes 21-28 and Z value codes 31-38) APP: 3D point (list of three reals)
38  DXF: entity's elevation if nonzero
39  Entity's thickness if nonzero (fixed)
40-48  Double-precision floating-point values (text height, scale factors, and so on)
48  Linetype scale; double precision floating point scalar value; default value is defined for all entity types
49  Repeated double-precision floating-point value. Multiple 49 groups may appear in one entity for variable-length tables (such as the dash lengths in the LTYPE table). A 7x group always appears before the first 49 group to specify the table length
50-58  Angles (output in degrees to DXF files and radians through AutoLISP and ObjectARX applications)
60  Entity visibility; integer value; absence or 0 indicates visibility; 1indicates invisibility
62  Color number (fixed)
66  "Entities follow" flag (fixed)
67  Space—that is, model or paper space (fixed)
68  APP: identifies whether viewport is on but fully off screen; is not active or is off
69  APP: viewport identification number
70-78   Integer values, such as repeat counts, flag bits, or modes
90-99   32-bit integer values
100 Subclass data marker (with derived class name as a string).
102 Control string, followed by “{<arbitrary name>” or “}”.
105  Object handle for DIMVAR symbol table entry
110(120,130) UCS origin (appears only if code 72 is set to 1) DXF: X value; APP: 3D point
111(121,131) UCS X-axis (appears only if code 72 is set to 1) DXF: X value; APP: 3D vector
112(122,132) UCS Y-axis (appears only if code 72 is set to 1) DXF: X value; APP: 3D vector
140-149 Double-precision floating-point values (points, elevation, and DIMSTYLE settings, for example)
170-179 16-bit integer values, such as flag bits representing DIMSTYLE settings
210(220,230) Extrusion direction (fixed)
*/