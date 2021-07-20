package com.abplus.dxf.models


/**
 * # Entity
 *
 * 　DXFを扱っていると、エンティティという言葉が頻出します。
 * 直訳すると「実体」というような意味になりますが、
 * 仕様上で定義されているわけではないこともあり、
 * そのままでは抽象的すぎてよく分かりません。
 *
 * 　なので、勝手に推測してしまうと、エンティティというのは、
 *
 * * グループコード:0 エンティティのタイプ（エンティティの始点）
 * * グループコード:2 エンティティの名前
 * * グループコード:6 エンティティのハンドル値
 *
 * を持ったセルの集まりと思っておけば問題ないでしょう。
 *
 * ハンドル値というのは、DXFのファイル内でユニークな64bit値で、
 * 多分、実際にはAutoCAD内で使用してるポインタ（のポインタ？）だと思います。
 *
 * 図面上の要素（線分や弧など）は、
 * ENTITIESセクションに、このエンティティという形で保持されます。
 * それ以外にもBLOCKSセクションやTABLESセクションでも使用されていて、
 * R13で追加されたCLASSESセクションやOBJECTSセクション以外（つまり
 * R12以前から使われているセクション）では、基本的なデータ構造となっています。
 */
@Suppress("unused")
public data class Entity(val cells: List<Cell>) {

    constructor(type: Type, name: String, handle: Long = 0L): this(
        listOf(
            Cell(Cell.GroupCodes.TYPE, type.typeName),
            Cell(Cell.GroupCodes.NAME, name),
            Cell(Cell.GroupCodes.HANDLE, handle.toString())
        )
    );

    fun assoc(groupCode: Cell.GroupCodes): Cell? = cells.find { it.groupCode == groupCode }

    val typeAsString: String? get() = assoc(Cell.GroupCodes.TYPE)?.asString
    val type: Type? get() = Type.findByName(typeAsString);
    val handle: Long? get() = assoc(Cell.GroupCodes.HANDLE)?.asLong
    val name: String? get() = assoc(Cell.GroupCodes.NAME)?.asString
}
