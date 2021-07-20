package com.abplus.dxf.models

/**
 * # Type
 *
 * 　グループコードが0のセルは、データ（主にエンティティ）のタイプを表しています。
 *
 * 　ここでは、よく使われるタイプをリストアップしています。
 * ただし、完全に全てを網羅することは困難なので、必要になった時点で追加していくことにします。
 */
@Suppress("unused")
public enum class Type(val typeName: String) {
    SECTION("SECTION"),     //  セクションの始まり
    ENDSEC("ENDSEC"),       //  セクションの終わり
    CLASS("CLASS"),         //  クラス
    TABLE("TABLE"),         //  テーブル
    ENDTAB("ENDTAB"),       //  テーブルの終わり
    VPORT("VPORT"),         //  ビュー・ポート
    LTYPE("LTYPE"),         //  線種
    LAYER("LAYER"),         //  レイヤ
    STYLE("STYLE"),         //  スタイル
    APPID("APPID"),         //  アプリケーションID
    DIMSTYLE("DIMSTYLE"),   //  寸法スタイル
    BLOCK_RECORD("BLOCK_RECORD"),   //  ブロック・レコード（is何？: todo）
    BLOCK("BLOCK"),         //  ブロック
    ENDBLK("ENDBLK"),       //  ブロックの終わり
    LINE("LINE"),           //  線分
    SOLID("SOLID"),         //  塗りつぶし
    MTEXT("MTEXT"),         //  長い文字列（複数行可）
    POINT("POINT"),         //  点
    ARC("ARC"),             //  円弧
    INSERT("INSERT"),       //  挿入（何を？: todo）
    LWPOLYLINE("LWPOLYLINE"),   //  ポリライン
    CIRCLE("CIRCLE"),           //  円
    DIMENSION("DIMENSION"),
    ELLIPSE("ELLIPSE"),
    ACDBDICTIONARYWDFLT("ACDBDICTIONARYWDFLT"),
    ACDBPLACEHOLDER("ACDBPLACEHOLDER"),
    DICTIONARY("DICTIONARY"),
    DICTIONARYVAR("DICTIONARYVAR"),
    EOF("EOF"),
    GROUP("GROUP"),
    HATCH("HATCH"),
    MLINESTYLE("MLINESTYLE"),
    REGION("REGION"),
    SPLINE("SPLINE"),
    TEXT("TEXT"),
    XRECORD("XRECORD"),
    UNKNOWN("");

    companion object {
        public fun findByName(typeName: String?): Type? = values().find { it.typeName == typeName }
    }
}