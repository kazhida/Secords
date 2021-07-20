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
    constructor(groupCode: GroupCodes, value: Short): this(groupCode, value.toString())
    constructor(groupCode: GroupCodes, value: Int): this(groupCode, value.toString())
    constructor(groupCode: GroupCodes, value: Long): this(groupCode, value.toString())
    constructor(groupCode: GroupCodes, value: Float): this(groupCode, value.toString())
    constructor(groupCode: GroupCodes, value: Double): this(groupCode, value.toString())

    /**
     * 文字列としての値
     */
    val asString: String get() = raw

    /**
     * 16bit整数としての値
     */
    val asShort: Short? get() = raw.toShortOrNull()

    /**
     * 32bit整数としての値
     */
    val asInt: Int? get() = raw.toIntOrNull()

    /**
     * 64bit整数としての値
     */
    val asLong: Long? get() = raw.toLongOrNull()

    /**
     * 単精度不動点小数としての値
     */
    val asFloat: Float? get() = raw.toFloatOrNull()

    /**
     * 倍精度不動点小数としての値
     */
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
        EXTRUSION_DIRECTION_Z(230),
        //  231-269 is not used
        //  ここから先は、拡張されてはいるものの、使い方が明示されてない
        INT16_VALUE20(270),
        INT16_VALUE21(271),
        INT16_VALUE22(272),
        INT16_VALUE23(273),
        INT16_VALUE24(274),
        INT16_VALUE25(275),
        INT16_VALUE26(276),
        INT16_VALUE27(277),
        INT16_VALUE28(278),
        INT16_VALUE29(279),
        INT16_VALUE30(280),
        INT16_VALUE31(281),
        INT16_VALUE32(282),
        INT16_VALUE33(283),
        INT16_VALUE34(284),
        INT16_VALUE35(285),
        INT16_VALUE36(286),
        INT16_VALUE37(287),
        INT16_VALUE38(288),
        INT16_VALUE39(289),
        BOOLEAN_VALUE0(290),
        BOOLEAN_VALUE1(291),
        BOOLEAN_VALUE2(292),
        BOOLEAN_VALUE3(293),
        BOOLEAN_VALUE4(294),
        BOOLEAN_VALUE5(295),
        BOOLEAN_VALUE6(296),
        BOOLEAN_VALUE7(297),
        BOOLEAN_VALUE8(298),
        BOOLEAN_VALUE9(299),
        ARBITRARY_TEXT0(300),
        ARBITRARY_TEXT1(301),
        ARBITRARY_TEXT2(302),
        ARBITRARY_TEXT3(303),
        ARBITRARY_TEXT4(304),
        ARBITRARY_TEXT5(305),
        ARBITRARY_TEXT6(306),
        ARBITRARY_TEXT7(307),
        ARBITRARY_TEXT8(308),
        ARBITRARY_TEXT9(309),
        BINARY_CHUNK_HEX0(310),
        BINARY_CHUNK_HEX1(311),
        BINARY_CHUNK_HEX2(312),
        BINARY_CHUNK_HEX3(313),
        BINARY_CHUNK_HEX4(314),
        BINARY_CHUNK_HEX5(315),
        BINARY_CHUNK_HEX6(316),
        BINARY_CHUNK_HEX7(317),
        BINARY_CHUNK_HEX8(318),
        BINARY_CHUNK_HEX9(319),
        HANDLE_HEX0(320),
        HANDLE_HEX1(321),
        HANDLE_HEX2(322),
        HANDLE_HEX3(323),
        HANDLE_HEX4(324),
        HANDLE_HEX5(325),
        HANDLE_HEX6(326),
        HANDLE_HEX7(327),
        HANDLE_HEX8(328),
        HANDLE_HEX9(329),
        OBJECT_IDS_HEX0(330),
        OBJECT_IDS_HEX1(331),
        OBJECT_IDS_HEX2(332),
        OBJECT_IDS_HEX3(333),
        OBJECT_IDS_HEX4(334),
        OBJECT_IDS_HEX5(335),
        OBJECT_IDS_HEX6(336),
        OBJECT_IDS_HEX7(337),
        OBJECT_IDS_HEX8(338),
        OBJECT_IDS_HEX9(339),
        OBJECT_IDS_HEX10(340),
        OBJECT_IDS_HEX11(341),
        OBJECT_IDS_HEX12(342),
        OBJECT_IDS_HEX13(343),
        OBJECT_IDS_HEX14(344),
        OBJECT_IDS_HEX15(345),
        OBJECT_IDS_HEX16(346),
        OBJECT_IDS_HEX17(347),
        OBJECT_IDS_HEX18(348),
        OBJECT_IDS_HEX19(349),
        OBJECT_IDS_HEX20(350),
        OBJECT_IDS_HEX21(351),
        OBJECT_IDS_HEX22(352),
        OBJECT_IDS_HEX23(353),
        OBJECT_IDS_HEX24(354),
        OBJECT_IDS_HEX25(355),
        OBJECT_IDS_HEX26(356),
        OBJECT_IDS_HEX27(357),
        OBJECT_IDS_HEX28(358),
        OBJECT_IDS_HEX29(359),
        OBJECT_IDS_HEX30(360),
        OBJECT_IDS_HEX31(361),
        OBJECT_IDS_HEX32(362),
        OBJECT_IDS_HEX33(363),
        OBJECT_IDS_HEX34(364),
        OBJECT_IDS_HEX35(365),
        OBJECT_IDS_HEX36(366),
        OBJECT_IDS_HEX37(367),
        OBJECT_IDS_HEX38(368),
        OBJECT_IDS_HEX39(369),
        INT16_VALUE40(370),
        INT16_VALUE41(371),
        INT16_VALUE42(372),
        INT16_VALUE43(373),
        INT16_VALUE44(374),
        INT16_VALUE45(375),
        INT16_VALUE46(376),
        INT16_VALUE47(377),
        INT16_VALUE48(378),
        INT16_VALUE49(379),
        INT16_VALUE50(380),
        INT16_VALUE51(381),
        INT16_VALUE52(382),
        INT16_VALUE53(383),
        INT16_VALUE54(384),
        INT16_VALUE55(385),
        INT16_VALUE56(386),
        INT16_VALUE57(387),
        INT16_VALUE58(388),
        INT16_VALUE59(389),
        HANDLE_HEX10(390),
        HANDLE_HEX11(391),
        HANDLE_HEX12(392),
        HANDLE_HEX13(393),
        HANDLE_HEX14(394),
        HANDLE_HEX15(395),
        HANDLE_HEX16(396),
        HANDLE_HEX17(397),
        HANDLE_HEX18(398),
        HANDLE_HEX19(399),
        INT16_VALUE60(400),
        INT16_VALUE61(401),
        INT16_VALUE62(402),
        INT16_VALUE63(403),
        INT16_VALUE64(404),
        INT16_VALUE65(405),
        INT16_VALUE66(406),
        INT16_VALUE67(407),
        INT16_VALUE68(408),
        INT16_VALUE69(409),
        STRING_VALUE0(410),
        STRING_VALUE1(411),
        STRING_VALUE2(412),
        STRING_VALUE3(413),
        STRING_VALUE4(414),
        STRING_VALUE5(415),
        STRING_VALUE6(416),
        STRING_VALUE7(417),
        STRING_VALUE8(418),
        STRING_VALUE9(419),
        INT32_VALUE10(420),
        INT32_VALUE11(421),
        INT32_VALUE12(422),
        INT32_VALUE13(423),
        INT32_VALUE14(424),
        INT32_VALUE15(425),
        INT32_VALUE16(426),
        INT32_VALUE17(427),
        INT32_VALUE18(428),
        INT32_VALUE19(429),
        STRING_VALUE10(430),
        STRING_VALUE11(431),
        STRING_VALUE12(432),
        STRING_VALUE13(433),
        STRING_VALUE14(434),
        STRING_VALUE15(435),
        STRING_VALUE16(436),
        STRING_VALUE17(437),
        STRING_VALUE18(438),
        STRING_VALUE19(439),
        INT32_VALUE20(440),
        INT32_VALUE21(441),
        INT32_VALUE22(442),
        INT32_VALUE23(443),
        INT32_VALUE24(444),
        INT32_VALUE25(445),
        INT32_VALUE26(446),
        INT32_VALUE27(447),
        INT32_VALUE28(448),
        INT32_VALUE29(449),
        LONG_VALUE0(450),
        LONG_VALUE1(451),
        LONG_VALUE2(452),
        LONG_VALUE3(453),
        LONG_VALUE4(454),
        LONG_VALUE5(455),
        LONG_VALUE6(456),
        LONG_VALUE7(457),
        LONG_VALUE8(458),
        LONG_VALUE9(459),
        DOUBLE_PRECISION_VALUE20(460),
        DOUBLE_PRECISION_VALUE21(461),
        DOUBLE_PRECISION_VALUE22(462),
        DOUBLE_PRECISION_VALUE23(463),
        DOUBLE_PRECISION_VALUE24(464),
        DOUBLE_PRECISION_VALUE25(465),
        DOUBLE_PRECISION_VALUE26(466),
        DOUBLE_PRECISION_VALUE27(467),
        DOUBLE_PRECISION_VALUE28(468),
        DOUBLE_PRECISION_VALUE29(469),
        STRING_VALUE20(470),
        STRING_VALUE21(471),
        STRING_VALUE22(472),
        STRING_VALUE23(473),
        STRING_VALUE24(474),
        STRING_VALUE25(475),
        STRING_VALUE26(476),
        STRING_VALUE27(477),
        STRING_VALUE28(478),
        STRING_VALUE29(479),
        HANDLE_HEX20(480),
        HANDLE_HEX21(481),
        //  482-998 is not used
        COMMENT(999),
        STRING_VALUE30(1000),
        STRING_VALUE31(1001),
        STRING_VALUE32(1002),
        STRING_VALUE33(1003),
        STRING_VALUE34(1004),
        STRING_VALUE35(1005),
        STRING_VALUE36(1006),
        STRING_VALUE37(1007),
        STRING_VALUE38(1008),
        STRING_VALUE39(1009),
        DOUBLE_PRECISION_VALUE30(1010),
        DOUBLE_PRECISION_VALUE31(1011),
        DOUBLE_PRECISION_VALUE32(1012),
        DOUBLE_PRECISION_VALUE33(1013),
        DOUBLE_PRECISION_VALUE34(1014),
        DOUBLE_PRECISION_VALUE35(1015),
        DOUBLE_PRECISION_VALUE36(1016),
        DOUBLE_PRECISION_VALUE37(1017),
        DOUBLE_PRECISION_VALUE38(1018),
        DOUBLE_PRECISION_VALUE39(1019),
        INT16_VALUE70(1060),
        INT16_VALUE71(1061),
        INT16_VALUE72(1062),
        INT16_VALUE73(1063),
        INT16_VALUE74(1064),
        INT16_VALUE75(1065),
        INT16_VALUE76(1066),
        INT16_VALUE77(1067),
        INT16_VALUE78(1068),
        INT16_VALUE79(1069),
        INT16_XDATA(1070),
        INT32_XDATA(1071);

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