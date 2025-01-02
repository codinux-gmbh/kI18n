package net.codinux.i18n.units

import kotlin.String

enum class UnitPrefix(
  val symbol: String,
  val conversionFactor: String,
) {
  Cubic("³", "1p3"),
  Square("²", "1p2"),
  Atto("a", "10p-18"),
  Centi("c", "10p-2"),
  Deci("d", "10p-1"),
  Deka("da", "10p1"),
  Exa("E", "10p18"),
  Exbi("Ei", "2p60"),
  Femto("f", "10p-15"),
  Gibi("Gi", "2p30"),
  Giga("G", "10p9"),
  Hecto("h", "10p2"),
  Kibi("Ki", "2p10"),
  Kilo("k", "10p3"),
  Mebi("Mi", "2p20"),
  Mega("M", "10p6"),
  Micro("μ", "10p-6"),
  Milli("m", "10p-3"),
  Nano("n", "10p-9"),
  Pebi("Pi", "2p50"),
  Peta("P", "10p15"),
  Pico("p", "10p-12"),
  Quecto("q", "10p-30"),
  Quetta("Q", "10p30"),
  Ronna("R", "10p27"),
  Ronto("r", "10p-27"),
  Tebi("Ti", "2p40"),
  Tera("T", "10p12"),
  Yobi("Yi", "2p80"),
  Yocto("y", "10p-24"),
  Yotta("Y", "10p24"),
  Zebi("Zi", "2p70"),
  Zepto("z", "10p-21"),
  Zetta("Z", "10p21"),
}