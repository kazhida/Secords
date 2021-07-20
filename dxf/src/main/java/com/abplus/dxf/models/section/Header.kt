package com.abplus.dxf.models.section

import com.abplus.dxf.models.Cell
import java.util.HashMap

/**
 * # HEADERセクション
 *
 * 　DXFのはじめにあるセクションです。中身は、こんな感じになっています。
 *
 * ```
 * (  0 . SECTION)
 * (  2 . HEADER)
 * (  9 . $ACADVER)
 * (  1 . AC1015)
 * (  9 . $ACADMAINTVER)
 * ( 70 .    18)
 * (  9 . $DWGCODEPAGE)
 * (  3 . ANSI_932)
 * (  9 . $INSBASE)
 * ( 10 . 0.0)
 * ( 20 . 0.0)
 * ( 30 . 0.0)
 * :
 * (  0 . ENDSEC)
 * ```
 *
 * 　はじめの2つはセクションの開始のしるしとセクションの名前なので、省いて見てみると、
 *
 * ```
 * (  9 . $ACADVER)
 * (  1 . AC1015)
 * (  9 . $ACADMAINTVER)
 * ( 70 .    18)
 * (  9 . $DWGCODEPAGE)
 * (  3 . ANSI_932)
 * (  9 . $INSBASE)
 * ( 10 . 0.0)
 * ( 20 . 0.0)
 * ( 30 . 0.0)
 *  :
 * (  0 . ENDSEC)
 * ```
 *
 * 　一回おきに、グループコードが9のコンスセルになっているようです。
 * そして、その値は$から始まる識別子みたいですね。ってゆうか、そういうことなんですけど。
 *
 * 　HEADERセクションは、基本的には、
 * 2つのコンスセルが一組のkey-valueペアになっています。
 * おそらく、これはAutoCAD内で使っている設定を吐き出したものと考えて間違いないでしょう。
 * こんな感じ、
 *
 * ```
 * ((  9 . $ACADVER)      . (  1 . AC1015))
 * ((  9 . $ACADMAINTVER) . ( 70 .    18))
 * ((  9 . $DWGCODEPAGE)  . (  3 . ANSI_932))
 * ((  9 . $INSBASE)      . (( 10 . 0.0) ( 20 . 0.0) ( 30 . 0.0))
 *  :
 * (  0 . ENDSEC)
 * ```
 *
 * で、考えると、わかりやすいと思います。
 *
 * 　さりげなく流しましたが、上記の4つめのペアは、
 * 2つのコンスセルの組ではなく10, 20, 30のグループコードのセルをまとめて扱っています。
 * これらのグループコードは、3つで一つの3次元座標あるいは3次元ベクトルを表します。
 *
 * 　というわけで、上記の部分を口語訳すると、
 *
 * * 使用したAutoCADのバージョン(ACADVER)は、文字列表記で”AC1015″、
 * * 数値で表す(ACADVER)は、文字列表記で”AC1015″、
 * * 数値で表す(ACADMAINTVER)は、バージョン18、
 * * 使用している文字列エンコーディング(DWGCODEPAGE)はANSI932、
 * * 挿入基点(INSBASE)が座標(0, 0, 0)
 *
 * であることを意味しています。
 *
 * 　DXFを扱う用途によって違いはありますが、実際にはほとんどが必要のないデータです。
 * リファレンス・マニュアルから自分が必要なデータを拾い出し、
 * それ以外は、無視してしまいましょう(^-^)。
 */
@Suppress("unused")
public class Header {

    companion object {
        public val SECTION_NAME: String = "HEADER".intern()
    }

    val params: Map<String, Cell> = HashMap<String, Cell>()



    override fun toString(): String {
        val builder = StringBuilder();
        builder.append("(${SECTION_NAME} . (")
        for (key in params.keys) {
            builder.append("(${key} . ${params[key]})\n")
        }
        builder.append("))")
        return builder.toString()
    }
}
