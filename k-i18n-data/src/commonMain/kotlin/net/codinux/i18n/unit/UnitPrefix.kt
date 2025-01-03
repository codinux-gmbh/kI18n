package net.codinux.i18n.unit

import kotlin.String

enum class UnitPrefix(
  val symbol: String,
  val conversionFactor: String,
  val englishName: String,
) {
  Cubic("³", "1p3", "cubic "),
  Square("²", "1p2", "square "),
  Atto("a", "10p-18", "atto"),
  Centi("c", "10p-2", "centi"),
  Deci("d", "10p-1", "deci"),
  Deka("da", "10p1", "deka"),
  Exa("E", "10p18", "exa"),
  Exbi("Ei", "1024p6", "exbi"),
  Femto("f", "10p-15", "femto"),
  Gibi("Gi", "1024p3", "gibi"),
  Giga("G", "10p9", "giga"),
  Hecto("h", "10p2", "hecto"),
  Kibi("Ki", "1024p1", "kibi"),
  Kilo("k", "10p3", "kilo"),
  Mebi("Mi", "1024p2", "mebi"),
  Mega("M", "10p6", "mega"),
  Micro("μ", "10p-6", "micro"),
  Milli("m", "10p-3", "milli"),
  Nano("n", "10p-9", "nano"),
  Pebi("Pi", "1024p5", "pebi"),
  Peta("P", "10p15", "peta"),
  Pico("p", "10p-12", "pico"),
  Quecto("q", "10p-30", "quecto"),
  Quetta("Q", "10p30", "quetta"),
  Ronna("R", "10p27", "ronna"),
  Ronto("r", "10p-27", "ronto"),
  Tebi("Ti", "1024p4", "tebi"),
  Tera("T", "10p12", "tera"),
  Yobi("Yi", "1024p8", "yobi"),
  Yocto("y", "10p-24", "yocto"),
  Yotta("Y", "10p24", "yotta"),
  Zebi("Zi", "1024p7", "zebi"),
  Zepto("z", "10p-21", "zepto"),
  Zetta("Z", "10p21", "zetta"),
  ;

  companion object {
    fun forConversionFactor(conversionFactor: String): UnitPrefix = UnitPrefix.entries.first { it.conversionFactor == conversionFactor }
  }
}
