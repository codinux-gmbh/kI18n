package net.codinux.i18n.formatter

import kotlin.String
import net.codinux.collections.ImmutableMap
import net.codinux.collections.immutableMapOf
import net.codinux.i18n.NumberingSystem

object AvailableNumberFormats {
  private val decimalFormat_01: CurrencyFormat by lazy { CurrencyFormat("#,##0.###") }

  private val decimalFormat_02: CurrencyFormat by lazy { CurrencyFormat("#,##,##0.###") }

  private val decimalFormat_03: CurrencyFormat by lazy { CurrencyFormat("#,#0.###") }

  private val decimalFormats: ImmutableMap<String, String> by lazy { immutableMapOf(
    "decimalFormat_01" to "#,##0.###",
    "decimalFormat_02" to "#,##,##0.###",
    "decimalFormat_03" to "#,#0.###",
  ) }

  private val percentFormat_01: CurrencyFormat by lazy { CurrencyFormat("#,##0%") }

  private val percentFormat_02: CurrencyFormat by lazy { CurrencyFormat("#,##,##0%") }

  private val percentFormat_03: CurrencyFormat by lazy { CurrencyFormat("#,##0 %") }

  private val percentFormat_04: CurrencyFormat by lazy { CurrencyFormat("% #,#0;% -#,#0") }

  private val percentFormat_05: CurrencyFormat by lazy { CurrencyFormat("#,##,##0 %") }

  private val percentFormat_06: CurrencyFormat by lazy { CurrencyFormat("% #,##0") }

  private val percentFormat_07: CurrencyFormat by lazy { CurrencyFormat("%#,##0") }

  private val percentFormat_08: CurrencyFormat by lazy { CurrencyFormat("#,##0 %") }

  private val percentFormat_09: CurrencyFormat by lazy { CurrencyFormat("%#,#0") }

  private val percentFormats: ImmutableMap<String, String> by lazy { immutableMapOf(
    "percentFormat_01" to "#,##0%",
    "percentFormat_02" to "#,##,##0%",
    "percentFormat_03" to "#,##0 %",
    "percentFormat_04" to "% #,#0;% -#,#0",
    "percentFormat_05" to "#,##,##0 %",
    "percentFormat_06" to "% #,##0",
    "percentFormat_07" to "%#,##0",
    "percentFormat_08" to "#,##0 %",
    "percentFormat_09" to "%#,#0",
  ) }

  private val scientificFormat_01: CurrencyFormat by lazy { CurrencyFormat("#E0") }

  private val scientificFormat_02: CurrencyFormat by lazy { CurrencyFormat("[#E0]") }

  private val scientificFormat_03: CurrencyFormat by lazy { CurrencyFormat("#") }

  private val scientificFormats: ImmutableMap<String, String> by lazy { immutableMapOf(
    "scientificFormat_01" to "#E0",
    "scientificFormat_02" to "[#E0]",
    "scientificFormat_03" to "#",
  ) }

  private val currencyFormat_01: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_02: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_03: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00¤", "#,##0.00", null, "#,##0.00¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_04: CurrencyFormat by
      lazy { CurrencyFormat("‏#,##0.00 ¤;‏-#,##0.00 ¤", "#,##0.00", null, "؜#,##0.00¤;(؜#,##0.00¤)", "#,##0.00;(#,##0.00)", "؜#,##0.00 ¤;(؜#,##0.00 ¤)", "{0} ¤¤") }

  private val currencyFormat_05: CurrencyFormat by
      lazy { CurrencyFormat("‏#,##0.00 ¤", "#,##0.00", null, "‏#,##0.00 ¤", "#,##0.00", null, null) }

  private val currencyFormat_06: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_07: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_08: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_09: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_10: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_11: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤;(#,##0.00 ¤)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_12: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_13: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00;¤ -#,##0.00", "#,##0.00", null, "¤ #,##0.00;¤ -#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_14: CurrencyFormat by
      lazy { CurrencyFormat("#,##,##0.00¤", "#,##0.00", null, "#,##,##0.00¤;(#,##,##0.00¤)", "#,##,##0.00;(#,##,##0.00)", "#,##,##0.00 ¤;(#,##,##0.00 ¤)", "{0} ¤¤") }

  private val currencyFormat_15: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", "¤ #,##,##0.00", "¤#,##,##0.00;(¤#,##,##0.00)", "#,##,##0.00;(#,##,##0.00)", "¤ #,##,##0.00;(¤ #,##,##0.00)", "{0} ¤¤") }

  private val currencyFormat_16: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤#,##,##0.00;(¤#,##,##0.00)", "#,##,##0.00;(#,##,##0.00)", "¤ #,##,##0.00;(¤ #,##,##0.00)", "{0} ¤¤") }

  private val currencyFormat_17: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_18: CurrencyFormat by
      lazy { CurrencyFormat("#,##,##0.00¤", "#,##0.00", null, "#,##,##0.00¤;(#,##,##0.00¤)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_19: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_20: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_21: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, null) }

  private val currencyFormat_22: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_23: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00;¤-#,##0.00", "#,##0.00", null, "¤ #,##0.00;¤-#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_24: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤#,##,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_25: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_26: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_27: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", "¤ #,##0.00", "#,##0.00 ¤", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_28: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", "¤ #,##0.00", "¤ #,##0.00", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_29: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00;¤-#,##0.00", "#,##0.00", "¤ #,##0.00", "¤ #,##0.00;¤-#,##0.00", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_30: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_31: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00;¤ -#,##0.00", "#,##0.00", "¤ #,##0.00", "¤ #,##0.00;(¤ #,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_32: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", "¤ #,##0.00", "#,##0.00 ¤;(#,##0.00 ¤)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_33: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", "¤#,##0.00", "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_34: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00;(¤ #,##0.00)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_35: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00;¤-#,##0.00", "#,##0.00", null, "¤#,##0.00;¤-#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_36: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00;¤ -#,##0.00", "#,##0.00", null, "¤ #,##0.00;¤ -#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_37: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤;(#,##0.00 ¤)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_38: CurrencyFormat by
      lazy { CurrencyFormat("‎¤#,##0.00", "#,##0.00", null, "‎¤ #,##0.00;‎(¤ #,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_39: CurrencyFormat by
      lazy { CurrencyFormat("‎¤ #,##0.00", "#,##0.00", null, "‎¤ #,##0.00;‎(¤ #,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_40: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00;‎(¤ #,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_41: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_42: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00;¤ #,##0.00-", "#,##0.00", null, "¤ #,##0.00;(¤ #,##0.00)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_43: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##,##0.00;(¤#,##,##0.00)", "#,##,##0.00;(#,##,##0.00)", "¤ #,##,##0.00;(¤ #,##,##0.00)", "{0} ¤¤") }

  private val currencyFormat_44: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤#,##,##0.00;(¤#,##,##0.00)", "#,##,##0.00;(#,##,##0.00)", "¤ #,##,##0.00;(¤ #,##,##0.00)", "{0} ¤¤") }

  private val currencyFormat_45: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_46: CurrencyFormat by
      lazy { CurrencyFormat("‏#,##0.00 ‏¤;‏-#,##0.00 ‏¤", "#,##0.00", null, "‏#,##0.00 ‏¤;‏-#,##0.00 ‏¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_47: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤#,##,##0.00", "#,##0.00", null, "¤¤ {0}") }

  private val currencyFormat_48: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##,##0.00", "#,##,##0.00", "¤ #,##,##0.00", "{0} ¤¤") }

  private val currencyFormat_49: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00;(¤ #,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_50: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_51: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_52: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤;(#,##0.00 ¤)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_53: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00¤", "#,##0.00", null, "#,##0.00¤;(#,##0.00¤)", "#,##0.00;(#,##0.00)", "#,##0.00 ¤;(#,##0.00 ¤)", "{0} ¤¤") }

  private val currencyFormat_54: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_55: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_56: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_57: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_58: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_59: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00;¤- #,##0.00", "#,##0.00", null, "¤#,##0.00;¤- #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_60: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_61: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_62: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_63: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_64: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_65: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "¤ #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_66: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤;-#,##0.00 ¤", "#,##0.00", null, "¤ #,##0.00;(¤ #,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_67: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##,##0.00", "#,##0.00", null, "¤ #,##,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_68: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00;¤ -#,##0.00", "#,##0.00", null, "¤ #,##0.00;(¤ #,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_69: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_70: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_71: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤;(#,##0.00 ¤)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_72: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_73: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_74: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_75: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_76: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_77: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_78: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_79: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_80: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##0.00", "#,##0.00", "¤ #,##0.00", "{0} ¤¤") }

  private val currencyFormat_81: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_82: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##0.00", "#,##0.00", null, "¤ #,##0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_83: CurrencyFormat by
      lazy { CurrencyFormat("¤#,#0.00", "#,##0.00", null, "¤#,#0.00", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_84: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##0.00", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "#,##0.00 ¤;(#,##0.00 ¤)", "{0} ¤¤") }

  private val currencyFormat_85: CurrencyFormat by
      lazy { CurrencyFormat("¤ #,##,##0.00", "#,##0.00", "¤ #,##0.00", "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", "¤ #,##0.00;(¤ #,##0.00)", "{0} ¤¤") }

  private val currencyFormat_86: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "¤#,##0.00;(¤#,##0.00)", "#,##0.00;(#,##0.00)", null, "{0} ¤¤") }

  private val currencyFormat_87: CurrencyFormat by
      lazy { CurrencyFormat("#,##0.00 ¤", "#,##0.00", null, "#,##0.00 ¤", "#,##0.00", null, "{0} ¤¤") }

  private val currencyFormat_88: CurrencyFormat by
      lazy { CurrencyFormat("¤#,##,##0.00", "#,##0.00", null, "¤#,##,##0.00", "#,##,##0.00", null, "{0} ¤¤") }

  private val symbols_01: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_02: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_03: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "በቁጥር ሊገለጽ የማይችል", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_04: Symbols by
      lazy { Symbols(".", ",", "‎+", "‎-", "∞", "ليس رقمًا", "‎%‎", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_05: Symbols by
      lazy { Symbols("٫", "٬", "؜+", "؜-", "∞", "ليس رقمًا", "٪؜", "؉", "~", "أس", "×", "؛", ":", null, null, null, null, null) }

  private val symbols_06: Symbols by
      lazy { Symbols(",", ".", "‎+", "‎-", "∞", "ليس رقمًا", "‎%‎", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_07: Symbols by
      lazy { Symbols(".", ",", "‎+", "‎-", "∞", "ليس رقمًا", "٪", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_08: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "ND", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_09: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_10: Symbols by
      lazy { Symbols("٫", "٬", "‎+‎", "‎-‎", "∞", "NaN", "٪", "؉", "~", "×۱۰^", "×", "؛", ":", null, null, null, null, null) }

  private val symbols_11: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "≈", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_12: Symbols by
      lazy { Symbols("٫", "،", "+", "-", "∞", "ناعدد", "٪", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_13: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "ཨང་མེན་", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_14: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "x", ";", ":", null, null, null, null, null) }

  private val symbols_15: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "≈", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_16: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "Терхьаш дац", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_17: Symbols by
      lazy { Symbols(".", ",", "‎+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_18: Symbols by
      lazy { Symbols("٫", "٬", "‏+", "‏-", "∞", "NaN", "٪", "؉", "~", "اس", "×", "؛", ":", null, null, null, null, null) }

  private val symbols_19: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ".", null, null, null, null, null) }

  private val symbols_20: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "≈", "E", "·", ";", ":", null, null, null, null, null) }

  private val symbols_21: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "≈", "E", "·", ";", ":", null, ".", null, null, null) }

  private val symbols_22: Symbols by
      lazy { Symbols(".", "’", "+", "-", "∞", "NaN", "%", "‰", "≈", "E", "·", ";", ":", null, null, null, null, null) }

  private val symbols_23: Symbols by
      lazy { Symbols(".", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_24: Symbols by
      lazy { Symbols("٫", "٬", "؜+", "؜-", "∞", "NaN", "٪؜", "؉", "~", "اس", "×", "؛", ":", null, null, null, null, null) }

  private val symbols_25: Symbols by
      lazy { Symbols(".", ",", "+", "-", "གྲངས་མེད", "ཨང་མད", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_26: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "mnn", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_27: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "~", "e", "×", ";", ":", null, null, null, null, null) }

  private val symbols_28: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "·", ";", ":", null, null, null, null, null) }

  private val symbols_29: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "NaN", "%", "‰", "~", "e", "×", ";", ":", null, null, null, null, null) }

  private val symbols_30: Symbols by
      lazy { Symbols(".", "’", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "·", ";", ":", null, null, null, null, null) }

  private val symbols_31: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "·", ";", ".", null, null, null, null, null) }

  private val symbols_32: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ".", null, null, null, null, null) }

  private val symbols_33: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "×10^", "×", ";", ":", null, null, null, null, null) }

  private val symbols_34: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, ".", ",") }

  private val symbols_35: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "≈", "×10^", "×", ";", ":", null, null, null, null, null) }

  private val symbols_36: Symbols by
      lazy { Symbols(",", ".", "+", "−", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_37: Symbols by
      lazy { Symbols("٫", "٬", "‎+", "‎−", "∞", "ناعدد", "٪", "؉", "~", "×۱۰^", "×", "؛", ":", null, null, null, null, null) }

  private val symbols_38: Symbols by
      lazy { Symbols(".", ",", "‎+", "‎−", "∞", "ناعدد", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_39: Symbols by
      lazy { Symbols(".", "⹁", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", "⁏", ":", null, null, null, null, null) }

  private val symbols_40: Symbols by
      lazy { Symbols(".", "⹁", "+", "-", "∞", "NaN", "%", "‰", "~", "𞤉", "×", "⁏", ":", null, null, null, null, null) }

  private val symbols_41: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "epäluku", "%", "‰", "~", "E", "×", ";", ".", null, null, null, null, null) }

  private val symbols_42: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "≃", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_43: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "≃", "E", "×", ";", ":", null, null, ".", null, null) }

  private val symbols_44: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "≃", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_45: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "Nuimh", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_46: Symbols by
      lazy { Symbols(".", "’", "+", "−", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_47: Symbols by
      lazy { Symbols(".", ",", "‎+", "‎-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_48: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "ՈչԹ", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_49: Symbols by
      lazy { Symbols(".", "’", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_50: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "NaN", "%", "‰", "約", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_51: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "არ არის რიცხვი", "%", "‰", "≈", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_52: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "сан емес", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_53: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "0/0", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_54: Symbols by
      lazy { Symbols(".", "،", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_55: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "~", "×10^", "×", ";", ":", null, null, null, null, null) }

  private val symbols_56: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "сан эмес", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_57: Symbols by
      lazy { Symbols(",", "’", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_58: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "ບໍ່​ແມ່ນ​ໂຕ​ເລກ", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_59: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "∼", "×10^", "×", ";", ":", null, null, null, null, null) }

  private val symbols_60: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NS", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_61: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "ဂဏန်းမဟုတ်သော", "%", "‰", "~", "E", "×", "၊", ":", null, null, null, null, null) }

  private val symbols_62: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "ဂဏန်းမဟုတ်သော", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_63: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "ca.", "E", "×", ";", ":", ".", null, null, null, null) }

  private val symbols_64: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "≈", "E", "×", ";", ":", ".", null, null, null, null) }

  private val symbols_65: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "НН", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_66: Symbols by
      lazy { Symbols(",", ".", "‎+", "‎−", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_67: Symbols by
      lazy { Symbols(".", "’", "+", "−", "∞", "NaN", "%", "‰", "≈", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_68: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "не число", "%", "‰", "≈", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_69: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "чыыһыла буотах", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_70: Symbols by
      lazy { Symbols(".", "٬", "؜+", "؜-", "∞", "NaN", "٪؜", "؉", "~", "اس", "×", "؛", ":", null, null, null, null, null) }

  private val symbols_71: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "~", "·10^", "·", ";", ":", null, null, null, null, null) }

  private val symbols_72: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ".", null, null, null, null, null) }

  private val symbols_73: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "e", "×", ";", ":", null, null, null, null, null) }

  private val symbols_74: Symbols by
      lazy { Symbols(",", ".", "+", "−", "∞", "NaN", "%", "‰", "~", "e", "×", ";", ":", null, null, null, null, null) }

  private val symbols_75: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "epiloho", "%", "‰", "~", "E", "×", ";", ".", null, null, null, null, null) }

  private val symbols_76: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "MaL", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_77: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "~", "×10^", "×", ";", ":", ".", null, null, null, null) }

  private val symbols_78: Symbols by
      lazy { Symbols(",", " ", "+", "−", "∞", "NaN", "%", "‰", "~", "×10^", "×", ";", ".", ":", null, null, null, null) }

  private val symbols_79: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "san däl", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_80: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "TF", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_81: Symbols by
      lazy { Symbols("٫", "٬", "‎+‎", "‎-‎", "∞", "NaN", "٪", "؉", "~", "×۱۰^", "×", "؛", "٫", null, null, null, null, null) }

  private val symbols_82: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "Е", "×", ";", ":", null, null, null, null, null) }

  private val symbols_83: Symbols by
      lazy { Symbols("٫", "٬", "‎+‎", "‎-‎", "∞", "NaN", "%", "‰", "~", "×۱۰^", "×", ";", "٫", null, null, null, null, null) }

  private val symbols_84: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "son emas", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_85: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "ҳақиқий сон эмас", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_86: Symbols by
      lazy { Symbols(",", " ", "+", "-", "∞", "NaN", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_87: Symbols by
      lazy { Symbols(",", ".", "+", "-", "∞", "NaN", "%", "‰", "-", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_88: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "NaN", "%", "‰", "dáàṣì", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_89: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "NaN", "%", "‰", "dáàshì", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_90: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "非數值", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val symbols_91: Symbols by
      lazy { Symbols(".", ",", "+", "-", "∞", "非数值", "%", "‰", "~", "E", "×", ";", ":", null, null, null, null, null) }

  private val aa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val aa_DJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val aa_ER: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val af: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val af_NA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val agq: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val ak: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val am: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_03), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val an: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ann: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val apc: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ar: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_AE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_BH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_DJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_DZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_06), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_EG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_EH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_ER: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_IL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_IQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_JO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_KM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_KW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_LB: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_06), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_LY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_06), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_MA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_06), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_MR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_06), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_OM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_PS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_QA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_SA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_07), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_SD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_SO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_07), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_SS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_SY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_TD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_TN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.ArabicIndicDigits to symbols_05, NumberingSystem.WesternDigits to symbols_06), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val ar_YE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_04, NumberingSystem.ArabicIndicDigits to symbols_05), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_04, NumberingSystem.ArabicIndicDigits to currencyFormat_05)) }

  private val arn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val `as`: NumberFormat by
      lazy { NumberFormat(NumberingSystem.BanglaDigits, 1, mapOf(NumberingSystem.BanglaDigits to symbols_01, NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.BanglaDigits to decimalFormat_02), mapOf(NumberingSystem.BanglaDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.BanglaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.BanglaDigits to currencyFormat_06, NumberingSystem.WesternDigits to currencyFormat_06)) }

  private val asa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ast: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_08), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val az: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_09)) }

  private val az_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ExtendedArabicIndicDigits to symbols_10), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val az_Arab_IQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ExtendedArabicIndicDigits to symbols_10), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val az_Arab_TR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ExtendedArabicIndicDigits to symbols_10), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val az_Cyrl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val az_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_09)) }

  private val ba: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bal: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bal_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bal_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bas: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val be: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_11), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val be_tarask: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_11), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val bem: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val bew: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bez: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val bg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val bgc: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bgn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_12), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bgn_AE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_12), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bgn_AF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_12), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bgn_IR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_12), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bgn_OM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_12), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bho: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_12, NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val blo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_04), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_13)) }

  private val blt: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bm: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val bm_Nkoo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.NKoDigits to symbols_01), mapOf(NumberingSystem.NKoDigits to decimalFormat_01, NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.NKoDigits to percentFormat_01), mapOf(NumberingSystem.NKoDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.NKoDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.BanglaDigits, 1, mapOf(NumberingSystem.BanglaDigits to symbols_01, NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.BanglaDigits to decimalFormat_02), mapOf(NumberingSystem.BanglaDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.BanglaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.BanglaDigits to currencyFormat_14, NumberingSystem.WesternDigits to currencyFormat_14)) }

  private val bn_IN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.BanglaDigits, 1, mapOf(NumberingSystem.BanglaDigits to symbols_01, NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.BanglaDigits to decimalFormat_02), mapOf(NumberingSystem.BanglaDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.BanglaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.BanglaDigits to currencyFormat_15, NumberingSystem.WesternDigits to currencyFormat_16)) }

  private val bo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TibetanDigits to symbols_13), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.TibetanDigits to decimalFormat_01), mapOf(NumberingSystem.TibetanDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.TibetanDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.TibetanDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val bo_IN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TibetanDigits to symbols_13), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.TibetanDigits to decimalFormat_01), mapOf(NumberingSystem.TibetanDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.TibetanDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.TibetanDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val br: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_17)) }

  private val brx: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_14, NumberingSystem.DevanagariDigits to symbols_14), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.DevanagariDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_06, NumberingSystem.WesternDigits to currencyFormat_06)) }

  private val bs: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_15), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val bs_Cyrl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val bs_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_15), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val bss: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val byn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ca: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val ca_AD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val ca_ES_valencia: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val ca_FR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val ca_IT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val cad: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val cch: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ccp: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ChakmaDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChakmaDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.ChakmaDigits to decimalFormat_02), mapOf(NumberingSystem.ChakmaDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.ChakmaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.ChakmaDigits to currencyFormat_18, NumberingSystem.WesternDigits to currencyFormat_18)) }

  private val ccp_IN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ChakmaDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChakmaDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.ChakmaDigits to decimalFormat_02), mapOf(NumberingSystem.ChakmaDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.ChakmaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.ChakmaDigits to currencyFormat_18, NumberingSystem.WesternDigits to currencyFormat_18)) }

  private val ce: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_16), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val ceb: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_19)) }

  private val cgg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val cho: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val chr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val cic: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ckb: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_17, NumberingSystem.ArabicIndicDigits to symbols_18), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.ArabicIndicDigits to currencyFormat_21)) }

  private val ckb_IR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_17, NumberingSystem.ArabicIndicDigits to symbols_18), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.ArabicIndicDigits to currencyFormat_21)) }

  private val co: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val cs: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_22)) }

  private val csw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val cu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val cv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val cy: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val da: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_19), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val da_GL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_19), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val dav: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val de: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_20), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val de_AT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_21), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val de_BE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_20), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val de_CH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_22), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_23)) }

  private val de_IT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_20), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val de_LI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_22), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val de_LU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_20), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val dje: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_23), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val doi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_12, NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val dsb: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_20), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val dua: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val dv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ArabicIndicDigits to symbols_24), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01, NumberingSystem.ArabicIndicDigits to currencyFormat_21)) }

  private val dyo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val dz: NumberFormat by
      lazy { NumberFormat(NumberingSystem.TibetanDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TibetanDigits to symbols_25), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.TibetanDigits to decimalFormat_02), mapOf(NumberingSystem.TibetanDigits to percentFormat_05, NumberingSystem.WesternDigits to percentFormat_05), mapOf(NumberingSystem.TibetanDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.TibetanDigits to currencyFormat_24, NumberingSystem.WesternDigits to currencyFormat_24)) }

  private val ebu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val ee: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 3, mapOf(NumberingSystem.WesternDigits to symbols_26), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_25)) }

  private val ee_TG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 3, mapOf(NumberingSystem.WesternDigits to symbols_26), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_25)) }

  private val el: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_27), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val el_CY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_27), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val el_polyton: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_27), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val en: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_001: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_150: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_27)) }

  private val en_AE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_AG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_AI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_AS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_AT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_28), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_28)) }

  private val en_AU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_29), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_BB: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_BE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_27)) }

  private val en_BI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_BM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_BS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_BW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_BZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_CA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_CC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_CH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_30), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_29)) }

  private val en_CK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_CM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_CX: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_CY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_DE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_28), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_27)) }

  private val en_DG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_DK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_31), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_27)) }

  private val en_DM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_Dsrt: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val en_ER: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_FI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_32), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_27)) }

  private val en_FJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_FK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_FM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GB: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_GY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_HK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_ID: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_IE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_IL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_IM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_IN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_30)) }

  private val en_IO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_JE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_JM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_KE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_KI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_KN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_KY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_LC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_LR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_LS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MP: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MV: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_28)) }

  private val en_MW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_MY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_NA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_NF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_NG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_NL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_31)) }

  private val en_NR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_NU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_NZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_PG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_PH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_PK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_PN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_PR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_PW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_RW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SB: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_33), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_27)) }

  private val en_SG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_27), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_32)) }

  private val en_SL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SX: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_SZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_Shaw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val en_TC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_TK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_TO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_TT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_TV: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_TZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_UG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_UM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_VC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_VG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_VI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_VU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_WS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_ZA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_34), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_33)) }

  private val en_ZM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val en_ZW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_26)) }

  private val eo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val es: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val es_419: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_AR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_34)) }

  private val es_BO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_BR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_BZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_CL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_35)) }

  private val es_CO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val es_CR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_CU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_DO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val es_EA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val es_EC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_35)) }

  private val es_GQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_GT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_HN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_IC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val es_MX: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_NI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_PA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_PE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val es_PH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val es_PR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_PY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_36)) }

  private val es_SV: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_US: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val es_UY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_34)) }

  private val es_VE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_35)) }

  private val et: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_35), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val eu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_36), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_06), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_37)) }

  private val ewo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val fa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_37, NumberingSystem.WesternDigits to symbols_38), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_38, NumberingSystem.WesternDigits to currencyFormat_39)) }

  private val fa_AF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_37, NumberingSystem.WesternDigits to symbols_38), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_40, NumberingSystem.WesternDigits to currencyFormat_40)) }

  private val ff: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Adlm: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_BF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_CM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_GH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_GM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_GW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_LR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_MR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_NE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_NG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_SL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Adlm_SN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.AdlamDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_39, NumberingSystem.AdlamDigits to symbols_40), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.AdlamDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.AdlamDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.AdlamDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20, NumberingSystem.AdlamDigits to currencyFormat_20)) }

  private val ff_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_BF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_CM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_GH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_GM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_GN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_GW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_LR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_MR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_NE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_NG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ff_Latn_SL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val fi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_41), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val fil: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_41)) }

  private val fo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_36), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fo_DK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_36), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_BE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_BF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_BI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_BJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_BL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_CA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_11), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_CD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_CF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_CG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_CH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_43), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_CI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_CM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_DJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_DZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_GA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_GF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_GN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_GP: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_GQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_HT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_KM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_LU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_44), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_MA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_44), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_MC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_MF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_MG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_ML: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_MQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_MR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_MU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_NC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_NE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_PF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_PM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_RE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_RW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_SC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_SN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_SY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_TD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_TG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_TN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_VU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_WF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val fr_YT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_42), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val frr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val fur: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val fy: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_42)) }

  private val ga: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_45), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val ga_GB: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_45), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val gaa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val gd: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_41)) }

  private val gez: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val gez_ER: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val gl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_22)) }

  private val gn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val gsw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_46), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val gsw_FR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_46), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val gsw_LI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_46), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val gu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.GujaratiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.GujaratiDigits to decimalFormat_02), mapOf(NumberingSystem.GujaratiDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.GujaratiDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.GujaratiDigits to currencyFormat_43, NumberingSystem.WesternDigits to currencyFormat_44)) }

  private val guz: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val gv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val ha: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ha_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ArabicIndicDigits to symbols_24), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01, NumberingSystem.ArabicIndicDigits to currencyFormat_21)) }

  private val ha_Arab_SD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ArabicIndicDigits to symbols_24), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01, NumberingSystem.ArabicIndicDigits to currencyFormat_21)) }

  private val ha_GH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ha_NE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val haw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_45)) }

  private val he: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_47), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_46)) }

  private val hi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.DevanagariDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_02, NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_47, NumberingSystem.WesternDigits to currencyFormat_47)) }

  private val hi_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.WesternDigits to currencyFormat_48)) }

  private val hnj: NumberFormat by
      lazy { NumberFormat(NumberingSystem.NyiakengPuachueHmongDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.NyiakengPuachueHmongDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.NyiakengPuachueHmongDigits to decimalFormat_01), mapOf(NumberingSystem.NyiakengPuachueHmongDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.NyiakengPuachueHmongDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.NyiakengPuachueHmongDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val hnj_Hmnp: NumberFormat by
      lazy { NumberFormat(NumberingSystem.NyiakengPuachueHmongDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.NyiakengPuachueHmongDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.NyiakengPuachueHmongDigits to decimalFormat_01), mapOf(NumberingSystem.NyiakengPuachueHmongDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.NyiakengPuachueHmongDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.NyiakengPuachueHmongDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val hr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_36), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val hr_BA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_36), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val hsb: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_20), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val hu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val hy: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_48), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ia: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_49)) }

  private val id: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_19), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val ie: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_36)) }

  private val ig: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_50)) }

  private val ii: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val io: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val `is`: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val it: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val it_CH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_49), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_23)) }

  private val it_SM: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val it_VA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val iu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val iu_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ja: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_50), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_51)) }

  private val jbo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val jgo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val jmc: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val jv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09, NumberingSystem.JavaneseDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.JavaneseDigits to decimalFormat_01), mapOf(NumberingSystem.JavaneseDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.JavaneseDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.JavaneseDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ka: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_51), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val kaa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kaa_Cyrl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kaa_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val kaj: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kam: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val kcg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kde: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val kea: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_52)) }

  private val ken: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kgp: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val khq: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_23), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val ki: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val kk: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_52), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_09)) }

  private val kk_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kk_Cyrl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_52), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_09)) }

  private val kk_KZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_52), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_09)) }

  private val kkj: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_35)) }

  private val kln: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val km: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.KhmerDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.KhmerDigits to decimalFormat_01), mapOf(NumberingSystem.KhmerDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.KhmerDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.KhmerDigits to currencyFormat_53, NumberingSystem.WesternDigits to currencyFormat_53)) }

  private val kn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.KannadaDigits to symbols_01, NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.KannadaDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.KannadaDigits to percentFormat_01), mapOf(NumberingSystem.KannadaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.KannadaDigits to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val ko: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val ko_CN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val ko_KP: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val kok: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_53), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_54, NumberingSystem.WesternDigits to currencyFormat_55)) }

  private val kok_Deva: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_53), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_54, NumberingSystem.WesternDigits to currencyFormat_55)) }

  private val kok_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_24)) }

  private val kpe: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val kpe_GN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ks: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_54), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_56, NumberingSystem.WesternDigits to currencyFormat_56)) }

  private val ks_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_54), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_56, NumberingSystem.WesternDigits to currencyFormat_56)) }

  private val ks_Deva: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val ksb: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val ksf: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ksh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_55), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_57)) }

  private val ku: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_07), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val kw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val kxv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_58)) }

  private val kxv_Deva: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_24, NumberingSystem.WesternDigits to currencyFormat_24)) }

  private val kxv_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_58)) }

  private val kxv_Orya: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.OdiaDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.OdiaDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.OdiaDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.OdiaDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_24, NumberingSystem.OdiaDigits to currencyFormat_24)) }

  private val kxv_Telu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TeluguDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.TeluguDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.TeluguDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.TeluguDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_24, NumberingSystem.TeluguDigits to currencyFormat_24)) }

  private val ky: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_56), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val la: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val lag: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val lb: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val lg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val lij: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val lkt: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val lld: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val lmo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_57), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ln: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ln_AO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ln_CF: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ln_CG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val lo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_58, NumberingSystem.LaoDigits to symbols_58), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.LaoDigits to decimalFormat_01), mapOf(NumberingSystem.LaoDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.LaoDigits to scientificFormat_03, NumberingSystem.WesternDigits to scientificFormat_03), mapOf(NumberingSystem.LaoDigits to currencyFormat_35, NumberingSystem.WesternDigits to currencyFormat_35)) }

  private val lrc: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ExtendedArabicIndicDigits to symbols_10), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val lrc_IQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ExtendedArabicIndicDigits to symbols_10), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val lt: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_59), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ltg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val lu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val luo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val luy: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_59)) }

  private val lv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_60), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val mai: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_02, NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mas: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val mas_TZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val mdf: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mer: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val mfe: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_23), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_60)) }

  private val mgh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mgo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val mhn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mic: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mk: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_15), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ml: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.MalayalamDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.MalayalamDigits to decimalFormat_02), mapOf(NumberingSystem.MalayalamDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.MalayalamDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.MalayalamDigits to currencyFormat_50, NumberingSystem.WesternDigits to currencyFormat_50)) }

  private val mn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_61)) }

  private val mn_Mong: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.MongolianDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.MongolianDigits to decimalFormat_01), mapOf(NumberingSystem.MongolianDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.MongolianDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01, NumberingSystem.MongolianDigits to currencyFormat_01)) }

  private val mn_Mong_MN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.MongolianDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.MongolianDigits to decimalFormat_01), mapOf(NumberingSystem.MongolianDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.MongolianDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12, NumberingSystem.MongolianDigits to currencyFormat_12)) }

  private val mni: NumberFormat by
      lazy { NumberFormat(NumberingSystem.BanglaDigits, 1, mapOf(NumberingSystem.BanglaDigits to symbols_01, NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.BanglaDigits to decimalFormat_01), mapOf(NumberingSystem.BanglaDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.BanglaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.BanglaDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mni_Beng: NumberFormat by
      lazy { NumberFormat(NumberingSystem.BanglaDigits, 1, mapOf(NumberingSystem.BanglaDigits to symbols_01, NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.BanglaDigits to decimalFormat_01), mapOf(NumberingSystem.BanglaDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.BanglaDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.BanglaDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mni_Mtei: NumberFormat by
      lazy { NumberFormat(NumberingSystem.MeeteiMayekDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.MeeteiMayekDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.MeeteiMayekDigits to decimalFormat_01), mapOf(NumberingSystem.MeeteiMayekDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.MeeteiMayekDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01, NumberingSystem.MeeteiMayekDigits to currencyFormat_01)) }

  private val moh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_02, NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val ms: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val ms_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val ms_Arab_BN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_62)) }

  private val ms_BN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_55)) }

  private val ms_ID: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_19), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_63)) }

  private val ms_SG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val mt: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_64)) }

  private val mua: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val mus: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val my: NumberFormat by
      lazy { NumberFormat(NumberingSystem.MyanmarDigits, 1, mapOf(NumberingSystem.MyanmarDigits to symbols_61, NumberingSystem.WesternDigits to symbols_62), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.MyanmarDigits to decimalFormat_01), mapOf(NumberingSystem.MyanmarDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.MyanmarDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.MyanmarDigits to currencyFormat_65, NumberingSystem.WesternDigits to currencyFormat_65)) }

  private val myv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val mzn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ExtendedArabicIndicDigits to symbols_10), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val naq: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val nb: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_63), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_66)) }

  private val nb_SJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_63), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_66)) }

  private val nd: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val nds: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val nds_NL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ne: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.DevanagariDigits to percentFormat_02), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_67, NumberingSystem.WesternDigits to currencyFormat_67)) }

  private val ne_IN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.DevanagariDigits to percentFormat_02), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_67, NumberingSystem.WesternDigits to currencyFormat_67)) }

  private val nl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_68)) }

  private val nl_AW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_68)) }

  private val nl_BE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_68)) }

  private val nl_BQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_68)) }

  private val nl_CW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_68)) }

  private val nl_SR: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_68)) }

  private val nl_SX: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_68)) }

  private val nmg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val nn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_64), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_66)) }

  private val nnh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val no: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_63), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_66)) }

  private val nqo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.NKoDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_54, NumberingSystem.NKoDigits to symbols_54), mapOf(NumberingSystem.NKoDigits to decimalFormat_01, NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.NKoDigits to percentFormat_01), mapOf(NumberingSystem.NKoDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.NKoDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val nr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val nso: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_23), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_60)) }

  private val nus: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val nv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ny: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val nyn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val oc: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_08), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val oc_ES: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_08), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val om: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val om_KE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val or: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.OdiaDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.OdiaDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.OdiaDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.OdiaDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02, NumberingSystem.OdiaDigits to currencyFormat_02)) }

  private val os: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_65), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val os_RU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_65), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val osa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val pa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.GurmukhiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.GurmukhiDigits to decimalFormat_02), mapOf(NumberingSystem.GurmukhiDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.GurmukhiDigits to scientificFormat_02, NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.GurmukhiDigits to currencyFormat_69, NumberingSystem.WesternDigits to currencyFormat_69)) }

  private val pa_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_47), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val pa_Guru: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.GurmukhiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.GurmukhiDigits to decimalFormat_02), mapOf(NumberingSystem.GurmukhiDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.GurmukhiDigits to scientificFormat_02, NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.GurmukhiDigits to currencyFormat_69, NumberingSystem.WesternDigits to currencyFormat_69)) }

  private val pap: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val pap_AW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val pcm: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val pis: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val pl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val prg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ps: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_66), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_70, NumberingSystem.WesternDigits to currencyFormat_70)) }

  private val ps_PK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_66), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_70, NumberingSystem.WesternDigits to currencyFormat_70)) }

  private val pt: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val pt_AO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_CH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_CV: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_GQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_GW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_LU: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_MO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_MZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_PT: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_ST: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val pt_TL: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val qu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_61)) }

  private val qu_BO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_61)) }

  private val qu_EC: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_61)) }

  private val quc: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val raj: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val rhg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val rhg_Rohg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val rhg_Rohg_BD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val rif: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val rm: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_67), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val rn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val ro: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_71)) }

  private val ro_MD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_71)) }

  private val rof: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val ru: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_68), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ru_BY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_68), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ru_KG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_68), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ru_KZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_68), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ru_MD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_68), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ru_UA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_68), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val rw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val rwk: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val sa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.DevanagariDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_02, NumberingSystem.WesternDigits to scientificFormat_02), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_72, NumberingSystem.WesternDigits to currencyFormat_72)) }

  private val sah: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_69), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val saq: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val sat: NumberFormat by
      lazy { NumberFormat(NumberingSystem.OlChikiDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.OlChikiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.OlChikiDigits to decimalFormat_01), mapOf(NumberingSystem.OlChikiDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.OlChikiDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.OlChikiDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sat_Deva: NumberFormat by
      lazy { NumberFormat(NumberingSystem.DevanagariDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.DevanagariDigits to decimalFormat_01), mapOf(NumberingSystem.DevanagariDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sat_Olck: NumberFormat by
      lazy { NumberFormat(NumberingSystem.OlChikiDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.OlChikiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.OlChikiDigits to decimalFormat_01), mapOf(NumberingSystem.OlChikiDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.OlChikiDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.OlChikiDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sbp: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val sc: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val scn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sd: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ArabicIndicDigits to symbols_70), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ArabicIndicDigits to currencyFormat_21, NumberingSystem.WesternDigits to currencyFormat_73)) }

  private val sd_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ArabicIndicDigits to symbols_70), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ArabicIndicDigits to currencyFormat_21, NumberingSystem.WesternDigits to currencyFormat_73)) }

  private val sd_Deva: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sdh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ArabicIndicDigits to symbols_24), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01, NumberingSystem.ArabicIndicDigits to currencyFormat_21)) }

  private val sdh_IQ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ArabicIndicDigits to symbols_24), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01, NumberingSystem.ArabicIndicDigits to currencyFormat_21)) }

  private val se: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_71), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_74)) }

  private val se_FI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_71), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_74)) }

  private val se_SE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_71), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_74)) }

  private val seh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val ses: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_23), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val sg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_35)) }

  private val shi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val shi_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val shi_Tfng: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val shn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val shn_TH: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val si: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_72), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_03), mapOf(NumberingSystem.WesternDigits to currencyFormat_75)) }

  private val sid: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sk: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_73), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val skr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_74), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sma: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sma_NO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val smj: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val smj_NO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val smn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_75), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_74)) }

  private val sms: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val sn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_45)) }

  private val so: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_76), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_76)) }

  private val so_DJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_76), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_76)) }

  private val so_ET: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_76), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_76)) }

  private val so_KE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_76), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_76)) }

  private val sq: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_11), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_37)) }

  private val sq_MK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_11), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_37)) }

  private val sq_XK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 2, mapOf(NumberingSystem.WesternDigits to symbols_11), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_37)) }

  private val sr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Cyrl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Cyrl_BA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Cyrl_ME: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Cyrl_XK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Latn_BA: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Latn_ME: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val sr_Latn_XK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_11)) }

  private val ss: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val ss_SZ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val ssy: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val st: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_56)) }

  private val st_LS: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_56)) }

  private val su: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_19), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val su_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_19), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val sv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_77), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val sv_AX: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_77), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val sv_FI: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_78), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val sw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_77)) }

  private val sw_CD: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_77)) }

  private val sw_KE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_78)) }

  private val sw_UG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_77)) }

  private val syr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val syr_SY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val szl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ta: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TamilDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.TamilDigits to decimalFormat_02), mapOf(NumberingSystem.TamilDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.TamilDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_54, NumberingSystem.TamilDigits to currencyFormat_79)) }

  private val ta_LK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TamilDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.TamilDigits to decimalFormat_02), mapOf(NumberingSystem.TamilDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.TamilDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_54, NumberingSystem.TamilDigits to currencyFormat_79)) }

  private val ta_MY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TamilDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.TamilDigits to decimalFormat_01), mapOf(NumberingSystem.TamilDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.TamilDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_55, NumberingSystem.TamilDigits to currencyFormat_79)) }

  private val ta_SG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TamilDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.TamilDigits to decimalFormat_01), mapOf(NumberingSystem.TamilDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.TamilDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_55, NumberingSystem.TamilDigits to currencyFormat_79)) }

  private val te: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.TeluguDigits to symbols_01), mapOf(NumberingSystem.TeluguDigits to decimalFormat_01, NumberingSystem.WesternDigits to decimalFormat_02), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.TeluguDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.TeluguDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_54, NumberingSystem.TeluguDigits to currencyFormat_54)) }

  private val teo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val teo_KE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val tg: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_09)) }

  private val th: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ThaiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ThaiDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ThaiDigits to percentFormat_01), mapOf(NumberingSystem.ThaiDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.ThaiDigits to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val ti: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_80)) }

  private val ti_ER: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_80)) }

  private val tig: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val tk: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_79), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_81)) }

  private val tn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_49), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_56)) }

  private val tn_BW: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_49), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_56)) }

  private val to: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_80), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_82)) }

  private val tok: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_03), mapOf(NumberingSystem.WesternDigits to percentFormat_09), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_83)) }

  private val tpi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val tr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_07), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_84)) }

  private val tr_CY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_07), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_84)) }

  private val trv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val trw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ts: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val tt: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val twq: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_23), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val tyv: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val tzm: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val ug: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ExtendedArabicIndicDigits to symbols_81), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_45, NumberingSystem.WesternDigits to currencyFormat_45)) }

  private val uk: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_82), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val und: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val ur: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_47, NumberingSystem.ExtendedArabicIndicDigits to symbols_83), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02, NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_41)) }

  private val ur_IN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_47, NumberingSystem.ExtendedArabicIndicDigits to symbols_83), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02, NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_85)) }

  private val uz: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_84), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_86)) }

  private val uz_Arab: NumberFormat by
      lazy { NumberFormat(NumberingSystem.ExtendedArabicIndicDigits, 1, mapOf(NumberingSystem.ExtendedArabicIndicDigits to symbols_10, NumberingSystem.WesternDigits to symbols_66), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ExtendedArabicIndicDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ExtendedArabicIndicDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ExtendedArabicIndicDigits to scientificFormat_01), mapOf(NumberingSystem.ExtendedArabicIndicDigits to currencyFormat_01, NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val uz_Cyrl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_85), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_08)) }

  private val uz_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_84), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_86)) }

  private val vai: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.VaiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.VaiDigits to decimalFormat_01), mapOf(NumberingSystem.VaiDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.VaiDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.VaiDigits to currencyFormat_10, NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val vai_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.VaiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.VaiDigits to decimalFormat_01), mapOf(NumberingSystem.VaiDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.VaiDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.VaiDigits to currencyFormat_10, NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val vai_Vaii: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.VaiDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.VaiDigits to decimalFormat_01), mapOf(NumberingSystem.VaiDigits to percentFormat_01, NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.VaiDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.VaiDigits to currencyFormat_10, NumberingSystem.WesternDigits to currencyFormat_10)) }

  private val ve: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val vec: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_86), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_87)) }

  private val vi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_09)) }

  private val vmw: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val vo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val vun: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val wa: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val wae: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_57), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val wal: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val wbp: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val wo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_87), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val xh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_23), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_12)) }

  private val xnr: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.DevanagariDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_02, NumberingSystem.DevanagariDigits to decimalFormat_02), mapOf(NumberingSystem.DevanagariDigits to percentFormat_02, NumberingSystem.WesternDigits to percentFormat_02), mapOf(NumberingSystem.DevanagariDigits to scientificFormat_01, NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.DevanagariDigits to currencyFormat_88, NumberingSystem.WesternDigits to currencyFormat_88)) }

  private val xog: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_07)) }

  private val yav: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_52)) }

  private val yi: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val yo: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_88), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_50)) }

  private val yo_BJ: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_89), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_50)) }

  private val yrl: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val yrl_CO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val yrl_VE: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_09), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_20)) }

  private val yue: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_90, NumberingSystem.ChineseDecimalNumerals to symbols_90), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val yue_Hans: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_91, NumberingSystem.ChineseDecimalNumerals to symbols_91), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val yue_Hant: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_90, NumberingSystem.ChineseDecimalNumerals to symbols_90), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val yue_Hant_CN: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_90, NumberingSystem.ChineseDecimalNumerals to symbols_90), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val za: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val zgh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_02), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_03), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_03)) }

  private val zh: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChineseDecimalNumerals to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_51)) }

  private val zh_Hans: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChineseDecimalNumerals to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_51)) }

  private val zh_Hans_HK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChineseDecimalNumerals to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val zh_Hans_MO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChineseDecimalNumerals to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val zh_Hans_MY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChineseDecimalNumerals to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_51)) }

  private val zh_Hans_SG: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01, NumberingSystem.ChineseDecimalNumerals to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val zh_Hant: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_90, NumberingSystem.ChineseDecimalNumerals to symbols_90), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val zh_Hant_HK: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_90, NumberingSystem.ChineseDecimalNumerals to symbols_90), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val zh_Hant_MO: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_90, NumberingSystem.ChineseDecimalNumerals to symbols_90), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val zh_Hant_MY: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_90, NumberingSystem.ChineseDecimalNumerals to symbols_90), mapOf(NumberingSystem.WesternDigits to decimalFormat_01, NumberingSystem.ChineseDecimalNumerals to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01, NumberingSystem.ChineseDecimalNumerals to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01, NumberingSystem.ChineseDecimalNumerals to scientificFormat_01), mapOf(NumberingSystem.ChineseDecimalNumerals to currencyFormat_02, NumberingSystem.WesternDigits to currencyFormat_02)) }

  private val zh_Latn: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_01)) }

  private val zu: NumberFormat by
      lazy { NumberFormat(NumberingSystem.WesternDigits, 1, mapOf(NumberingSystem.WesternDigits to symbols_01), mapOf(NumberingSystem.WesternDigits to decimalFormat_01), mapOf(NumberingSystem.WesternDigits to percentFormat_01), mapOf(NumberingSystem.WesternDigits to scientificFormat_01), mapOf(NumberingSystem.WesternDigits to currencyFormat_02)) }

  fun getNumberFormat(languageTag: String): NumberFormat? = when(languageTag) {
    "aa" -> aa
    "aa-DJ" -> aa_DJ
    "aa-ER" -> aa_ER
    "ab" -> ab
    "af" -> af
    "af-NA" -> af_NA
    "agq" -> agq
    "ak" -> ak
    "am" -> am
    "an" -> an
    "ann" -> ann
    "apc" -> apc
    "ar" -> ar
    "ar-AE" -> ar_AE
    "ar-BH" -> ar_BH
    "ar-DJ" -> ar_DJ
    "ar-DZ" -> ar_DZ
    "ar-EG" -> ar_EG
    "ar-EH" -> ar_EH
    "ar-ER" -> ar_ER
    "ar-IL" -> ar_IL
    "ar-IQ" -> ar_IQ
    "ar-JO" -> ar_JO
    "ar-KM" -> ar_KM
    "ar-KW" -> ar_KW
    "ar-LB" -> ar_LB
    "ar-LY" -> ar_LY
    "ar-MA" -> ar_MA
    "ar-MR" -> ar_MR
    "ar-OM" -> ar_OM
    "ar-PS" -> ar_PS
    "ar-QA" -> ar_QA
    "ar-SA" -> ar_SA
    "ar-SD" -> ar_SD
    "ar-SO" -> ar_SO
    "ar-SS" -> ar_SS
    "ar-SY" -> ar_SY
    "ar-TD" -> ar_TD
    "ar-TN" -> ar_TN
    "ar-YE" -> ar_YE
    "arn" -> arn
    "as" -> `as`
    "asa" -> asa
    "ast" -> ast
    "az" -> az
    "az-Arab" -> az_Arab
    "az-Arab-IQ" -> az_Arab_IQ
    "az-Arab-TR" -> az_Arab_TR
    "az-Cyrl" -> az_Cyrl
    "az-Latn" -> az_Latn
    "ba" -> ba
    "bal" -> bal
    "bal-Arab" -> bal_Arab
    "bal-Latn" -> bal_Latn
    "bas" -> bas
    "be" -> be
    "be-tarask" -> be_tarask
    "bem" -> bem
    "bew" -> bew
    "bez" -> bez
    "bg" -> bg
    "bgc" -> bgc
    "bgn" -> bgn
    "bgn-AE" -> bgn_AE
    "bgn-AF" -> bgn_AF
    "bgn-IR" -> bgn_IR
    "bgn-OM" -> bgn_OM
    "bho" -> bho
    "blo" -> blo
    "blt" -> blt
    "bm" -> bm
    "bm-Nkoo" -> bm_Nkoo
    "bn" -> bn
    "bn-IN" -> bn_IN
    "bo" -> bo
    "bo-IN" -> bo_IN
    "br" -> br
    "brx" -> brx
    "bs" -> bs
    "bs-Cyrl" -> bs_Cyrl
    "bs-Latn" -> bs_Latn
    "bss" -> bss
    "byn" -> byn
    "ca" -> ca
    "ca-AD" -> ca_AD
    "ca-ES-valencia" -> ca_ES_valencia
    "ca-FR" -> ca_FR
    "ca-IT" -> ca_IT
    "cad" -> cad
    "cch" -> cch
    "ccp" -> ccp
    "ccp-IN" -> ccp_IN
    "ce" -> ce
    "ceb" -> ceb
    "cgg" -> cgg
    "cho" -> cho
    "chr" -> chr
    "cic" -> cic
    "ckb" -> ckb
    "ckb-IR" -> ckb_IR
    "co" -> co
    "cs" -> cs
    "csw" -> csw
    "cu" -> cu
    "cv" -> cv
    "cy" -> cy
    "da" -> da
    "da-GL" -> da_GL
    "dav" -> dav
    "de" -> de
    "de-AT" -> de_AT
    "de-BE" -> de_BE
    "de-CH" -> de_CH
    "de-IT" -> de_IT
    "de-LI" -> de_LI
    "de-LU" -> de_LU
    "dje" -> dje
    "doi" -> doi
    "dsb" -> dsb
    "dua" -> dua
    "dv" -> dv
    "dyo" -> dyo
    "dz" -> dz
    "ebu" -> ebu
    "ee" -> ee
    "ee-TG" -> ee_TG
    "el" -> el
    "el-CY" -> el_CY
    "el-polyton" -> el_polyton
    "en" -> en
    "en-001" -> en_001
    "en-150" -> en_150
    "en-AE" -> en_AE
    "en-AG" -> en_AG
    "en-AI" -> en_AI
    "en-AS" -> en_AS
    "en-AT" -> en_AT
    "en-AU" -> en_AU
    "en-BB" -> en_BB
    "en-BE" -> en_BE
    "en-BI" -> en_BI
    "en-BM" -> en_BM
    "en-BS" -> en_BS
    "en-BW" -> en_BW
    "en-BZ" -> en_BZ
    "en-CA" -> en_CA
    "en-CC" -> en_CC
    "en-CH" -> en_CH
    "en-CK" -> en_CK
    "en-CM" -> en_CM
    "en-CX" -> en_CX
    "en-CY" -> en_CY
    "en-DE" -> en_DE
    "en-DG" -> en_DG
    "en-DK" -> en_DK
    "en-DM" -> en_DM
    "en-Dsrt" -> en_Dsrt
    "en-ER" -> en_ER
    "en-FI" -> en_FI
    "en-FJ" -> en_FJ
    "en-FK" -> en_FK
    "en-FM" -> en_FM
    "en-GB" -> en_GB
    "en-GD" -> en_GD
    "en-GG" -> en_GG
    "en-GH" -> en_GH
    "en-GI" -> en_GI
    "en-GM" -> en_GM
    "en-GU" -> en_GU
    "en-GY" -> en_GY
    "en-HK" -> en_HK
    "en-ID" -> en_ID
    "en-IE" -> en_IE
    "en-IL" -> en_IL
    "en-IM" -> en_IM
    "en-IN" -> en_IN
    "en-IO" -> en_IO
    "en-JE" -> en_JE
    "en-JM" -> en_JM
    "en-KE" -> en_KE
    "en-KI" -> en_KI
    "en-KN" -> en_KN
    "en-KY" -> en_KY
    "en-LC" -> en_LC
    "en-LR" -> en_LR
    "en-LS" -> en_LS
    "en-MG" -> en_MG
    "en-MH" -> en_MH
    "en-MO" -> en_MO
    "en-MP" -> en_MP
    "en-MS" -> en_MS
    "en-MT" -> en_MT
    "en-MU" -> en_MU
    "en-MV" -> en_MV
    "en-MW" -> en_MW
    "en-MY" -> en_MY
    "en-NA" -> en_NA
    "en-NF" -> en_NF
    "en-NG" -> en_NG
    "en-NL" -> en_NL
    "en-NR" -> en_NR
    "en-NU" -> en_NU
    "en-NZ" -> en_NZ
    "en-PG" -> en_PG
    "en-PH" -> en_PH
    "en-PK" -> en_PK
    "en-PN" -> en_PN
    "en-PR" -> en_PR
    "en-PW" -> en_PW
    "en-RW" -> en_RW
    "en-SB" -> en_SB
    "en-SC" -> en_SC
    "en-SD" -> en_SD
    "en-SE" -> en_SE
    "en-SG" -> en_SG
    "en-SH" -> en_SH
    "en-SI" -> en_SI
    "en-SL" -> en_SL
    "en-SS" -> en_SS
    "en-SX" -> en_SX
    "en-SZ" -> en_SZ
    "en-Shaw" -> en_Shaw
    "en-TC" -> en_TC
    "en-TK" -> en_TK
    "en-TO" -> en_TO
    "en-TT" -> en_TT
    "en-TV" -> en_TV
    "en-TZ" -> en_TZ
    "en-UG" -> en_UG
    "en-UM" -> en_UM
    "en-VC" -> en_VC
    "en-VG" -> en_VG
    "en-VI" -> en_VI
    "en-VU" -> en_VU
    "en-WS" -> en_WS
    "en-ZA" -> en_ZA
    "en-ZM" -> en_ZM
    "en-ZW" -> en_ZW
    "eo" -> eo
    "es" -> es
    "es-419" -> es_419
    "es-AR" -> es_AR
    "es-BO" -> es_BO
    "es-BR" -> es_BR
    "es-BZ" -> es_BZ
    "es-CL" -> es_CL
    "es-CO" -> es_CO
    "es-CR" -> es_CR
    "es-CU" -> es_CU
    "es-DO" -> es_DO
    "es-EA" -> es_EA
    "es-EC" -> es_EC
    "es-GQ" -> es_GQ
    "es-GT" -> es_GT
    "es-HN" -> es_HN
    "es-IC" -> es_IC
    "es-MX" -> es_MX
    "es-NI" -> es_NI
    "es-PA" -> es_PA
    "es-PE" -> es_PE
    "es-PH" -> es_PH
    "es-PR" -> es_PR
    "es-PY" -> es_PY
    "es-SV" -> es_SV
    "es-US" -> es_US
    "es-UY" -> es_UY
    "es-VE" -> es_VE
    "et" -> et
    "eu" -> eu
    "ewo" -> ewo
    "fa" -> fa
    "fa-AF" -> fa_AF
    "ff" -> ff
    "ff-Adlm" -> ff_Adlm
    "ff-Adlm-BF" -> ff_Adlm_BF
    "ff-Adlm-CM" -> ff_Adlm_CM
    "ff-Adlm-GH" -> ff_Adlm_GH
    "ff-Adlm-GM" -> ff_Adlm_GM
    "ff-Adlm-GW" -> ff_Adlm_GW
    "ff-Adlm-LR" -> ff_Adlm_LR
    "ff-Adlm-MR" -> ff_Adlm_MR
    "ff-Adlm-NE" -> ff_Adlm_NE
    "ff-Adlm-NG" -> ff_Adlm_NG
    "ff-Adlm-SL" -> ff_Adlm_SL
    "ff-Adlm-SN" -> ff_Adlm_SN
    "ff-Latn" -> ff_Latn
    "ff-Latn-BF" -> ff_Latn_BF
    "ff-Latn-CM" -> ff_Latn_CM
    "ff-Latn-GH" -> ff_Latn_GH
    "ff-Latn-GM" -> ff_Latn_GM
    "ff-Latn-GN" -> ff_Latn_GN
    "ff-Latn-GW" -> ff_Latn_GW
    "ff-Latn-LR" -> ff_Latn_LR
    "ff-Latn-MR" -> ff_Latn_MR
    "ff-Latn-NE" -> ff_Latn_NE
    "ff-Latn-NG" -> ff_Latn_NG
    "ff-Latn-SL" -> ff_Latn_SL
    "fi" -> fi
    "fil" -> fil
    "fo" -> fo
    "fo-DK" -> fo_DK
    "fr" -> fr
    "fr-BE" -> fr_BE
    "fr-BF" -> fr_BF
    "fr-BI" -> fr_BI
    "fr-BJ" -> fr_BJ
    "fr-BL" -> fr_BL
    "fr-CA" -> fr_CA
    "fr-CD" -> fr_CD
    "fr-CF" -> fr_CF
    "fr-CG" -> fr_CG
    "fr-CH" -> fr_CH
    "fr-CI" -> fr_CI
    "fr-CM" -> fr_CM
    "fr-DJ" -> fr_DJ
    "fr-DZ" -> fr_DZ
    "fr-GA" -> fr_GA
    "fr-GF" -> fr_GF
    "fr-GN" -> fr_GN
    "fr-GP" -> fr_GP
    "fr-GQ" -> fr_GQ
    "fr-HT" -> fr_HT
    "fr-KM" -> fr_KM
    "fr-LU" -> fr_LU
    "fr-MA" -> fr_MA
    "fr-MC" -> fr_MC
    "fr-MF" -> fr_MF
    "fr-MG" -> fr_MG
    "fr-ML" -> fr_ML
    "fr-MQ" -> fr_MQ
    "fr-MR" -> fr_MR
    "fr-MU" -> fr_MU
    "fr-NC" -> fr_NC
    "fr-NE" -> fr_NE
    "fr-PF" -> fr_PF
    "fr-PM" -> fr_PM
    "fr-RE" -> fr_RE
    "fr-RW" -> fr_RW
    "fr-SC" -> fr_SC
    "fr-SN" -> fr_SN
    "fr-SY" -> fr_SY
    "fr-TD" -> fr_TD
    "fr-TG" -> fr_TG
    "fr-TN" -> fr_TN
    "fr-VU" -> fr_VU
    "fr-WF" -> fr_WF
    "fr-YT" -> fr_YT
    "frr" -> frr
    "fur" -> fur
    "fy" -> fy
    "ga" -> ga
    "ga-GB" -> ga_GB
    "gaa" -> gaa
    "gd" -> gd
    "gez" -> gez
    "gez-ER" -> gez_ER
    "gl" -> gl
    "gn" -> gn
    "gsw" -> gsw
    "gsw-FR" -> gsw_FR
    "gsw-LI" -> gsw_LI
    "gu" -> gu
    "guz" -> guz
    "gv" -> gv
    "ha" -> ha
    "ha-Arab" -> ha_Arab
    "ha-Arab-SD" -> ha_Arab_SD
    "ha-GH" -> ha_GH
    "ha-NE" -> ha_NE
    "haw" -> haw
    "he" -> he
    "hi" -> hi
    "hi-Latn" -> hi_Latn
    "hnj" -> hnj
    "hnj-Hmnp" -> hnj_Hmnp
    "hr" -> hr
    "hr-BA" -> hr_BA
    "hsb" -> hsb
    "hu" -> hu
    "hy" -> hy
    "ia" -> ia
    "id" -> id
    "ie" -> ie
    "ig" -> ig
    "ii" -> ii
    "io" -> io
    "is" -> `is`
    "it" -> it
    "it-CH" -> it_CH
    "it-SM" -> it_SM
    "it-VA" -> it_VA
    "iu" -> iu
    "iu-Latn" -> iu_Latn
    "ja" -> ja
    "jbo" -> jbo
    "jgo" -> jgo
    "jmc" -> jmc
    "jv" -> jv
    "ka" -> ka
    "kaa" -> kaa
    "kaa-Cyrl" -> kaa_Cyrl
    "kaa-Latn" -> kaa_Latn
    "kab" -> kab
    "kaj" -> kaj
    "kam" -> kam
    "kcg" -> kcg
    "kde" -> kde
    "kea" -> kea
    "ken" -> ken
    "kgp" -> kgp
    "khq" -> khq
    "ki" -> ki
    "kk" -> kk
    "kk-Arab" -> kk_Arab
    "kk-Cyrl" -> kk_Cyrl
    "kk-KZ" -> kk_KZ
    "kkj" -> kkj
    "kl" -> kl
    "kln" -> kln
    "km" -> km
    "kn" -> kn
    "ko" -> ko
    "ko-CN" -> ko_CN
    "ko-KP" -> ko_KP
    "kok" -> kok
    "kok-Deva" -> kok_Deva
    "kok-Latn" -> kok_Latn
    "kpe" -> kpe
    "kpe-GN" -> kpe_GN
    "ks" -> ks
    "ks-Arab" -> ks_Arab
    "ks-Deva" -> ks_Deva
    "ksb" -> ksb
    "ksf" -> ksf
    "ksh" -> ksh
    "ku" -> ku
    "kw" -> kw
    "kxv" -> kxv
    "kxv-Deva" -> kxv_Deva
    "kxv-Latn" -> kxv_Latn
    "kxv-Orya" -> kxv_Orya
    "kxv-Telu" -> kxv_Telu
    "ky" -> ky
    "la" -> la
    "lag" -> lag
    "lb" -> lb
    "lg" -> lg
    "lij" -> lij
    "lkt" -> lkt
    "lld" -> lld
    "lmo" -> lmo
    "ln" -> ln
    "ln-AO" -> ln_AO
    "ln-CF" -> ln_CF
    "ln-CG" -> ln_CG
    "lo" -> lo
    "lrc" -> lrc
    "lrc-IQ" -> lrc_IQ
    "lt" -> lt
    "ltg" -> ltg
    "lu" -> lu
    "luo" -> luo
    "luy" -> luy
    "lv" -> lv
    "mai" -> mai
    "mas" -> mas
    "mas-TZ" -> mas_TZ
    "mdf" -> mdf
    "mer" -> mer
    "mfe" -> mfe
    "mg" -> mg
    "mgh" -> mgh
    "mgo" -> mgo
    "mhn" -> mhn
    "mi" -> mi
    "mic" -> mic
    "mk" -> mk
    "ml" -> ml
    "mn" -> mn
    "mn-Mong" -> mn_Mong
    "mn-Mong-MN" -> mn_Mong_MN
    "mni" -> mni
    "mni-Beng" -> mni_Beng
    "mni-Mtei" -> mni_Mtei
    "moh" -> moh
    "mr" -> mr
    "ms" -> ms
    "ms-Arab" -> ms_Arab
    "ms-Arab-BN" -> ms_Arab_BN
    "ms-BN" -> ms_BN
    "ms-ID" -> ms_ID
    "ms-SG" -> ms_SG
    "mt" -> mt
    "mua" -> mua
    "mus" -> mus
    "my" -> my
    "myv" -> myv
    "mzn" -> mzn
    "naq" -> naq
    "nb" -> nb
    "nb-SJ" -> nb_SJ
    "nd" -> nd
    "nds" -> nds
    "nds-NL" -> nds_NL
    "ne" -> ne
    "ne-IN" -> ne_IN
    "nl" -> nl
    "nl-AW" -> nl_AW
    "nl-BE" -> nl_BE
    "nl-BQ" -> nl_BQ
    "nl-CW" -> nl_CW
    "nl-SR" -> nl_SR
    "nl-SX" -> nl_SX
    "nmg" -> nmg
    "nn" -> nn
    "nnh" -> nnh
    "no" -> no
    "nqo" -> nqo
    "nr" -> nr
    "nso" -> nso
    "nus" -> nus
    "nv" -> nv
    "ny" -> ny
    "nyn" -> nyn
    "oc" -> oc
    "oc-ES" -> oc_ES
    "om" -> om
    "om-KE" -> om_KE
    "or" -> or
    "os" -> os
    "os-RU" -> os_RU
    "osa" -> osa
    "pa" -> pa
    "pa-Arab" -> pa_Arab
    "pa-Guru" -> pa_Guru
    "pap" -> pap
    "pap-AW" -> pap_AW
    "pcm" -> pcm
    "pis" -> pis
    "pl" -> pl
    "prg" -> prg
    "ps" -> ps
    "ps-PK" -> ps_PK
    "pt" -> pt
    "pt-AO" -> pt_AO
    "pt-CH" -> pt_CH
    "pt-CV" -> pt_CV
    "pt-GQ" -> pt_GQ
    "pt-GW" -> pt_GW
    "pt-LU" -> pt_LU
    "pt-MO" -> pt_MO
    "pt-MZ" -> pt_MZ
    "pt-PT" -> pt_PT
    "pt-ST" -> pt_ST
    "pt-TL" -> pt_TL
    "qu" -> qu
    "qu-BO" -> qu_BO
    "qu-EC" -> qu_EC
    "quc" -> quc
    "raj" -> raj
    "rhg" -> rhg
    "rhg-Rohg" -> rhg_Rohg
    "rhg-Rohg-BD" -> rhg_Rohg_BD
    "rif" -> rif
    "rm" -> rm
    "rn" -> rn
    "ro" -> ro
    "ro-MD" -> ro_MD
    "rof" -> rof
    "ru" -> ru
    "ru-BY" -> ru_BY
    "ru-KG" -> ru_KG
    "ru-KZ" -> ru_KZ
    "ru-MD" -> ru_MD
    "ru-UA" -> ru_UA
    "rw" -> rw
    "rwk" -> rwk
    "sa" -> sa
    "sah" -> sah
    "saq" -> saq
    "sat" -> sat
    "sat-Deva" -> sat_Deva
    "sat-Olck" -> sat_Olck
    "sbp" -> sbp
    "sc" -> sc
    "scn" -> scn
    "sd" -> sd
    "sd-Arab" -> sd_Arab
    "sd-Deva" -> sd_Deva
    "sdh" -> sdh
    "sdh-IQ" -> sdh_IQ
    "se" -> se
    "se-FI" -> se_FI
    "se-SE" -> se_SE
    "seh" -> seh
    "ses" -> ses
    "sg" -> sg
    "shi" -> shi
    "shi-Latn" -> shi_Latn
    "shi-Tfng" -> shi_Tfng
    "shn" -> shn
    "shn-TH" -> shn_TH
    "si" -> si
    "sid" -> sid
    "sk" -> sk
    "skr" -> skr
    "sl" -> sl
    "sma" -> sma
    "sma-NO" -> sma_NO
    "smj" -> smj
    "smj-NO" -> smj_NO
    "smn" -> smn
    "sms" -> sms
    "sn" -> sn
    "so" -> so
    "so-DJ" -> so_DJ
    "so-ET" -> so_ET
    "so-KE" -> so_KE
    "sq" -> sq
    "sq-MK" -> sq_MK
    "sq-XK" -> sq_XK
    "sr" -> sr
    "sr-Cyrl" -> sr_Cyrl
    "sr-Cyrl-BA" -> sr_Cyrl_BA
    "sr-Cyrl-ME" -> sr_Cyrl_ME
    "sr-Cyrl-XK" -> sr_Cyrl_XK
    "sr-Latn" -> sr_Latn
    "sr-Latn-BA" -> sr_Latn_BA
    "sr-Latn-ME" -> sr_Latn_ME
    "sr-Latn-XK" -> sr_Latn_XK
    "ss" -> ss
    "ss-SZ" -> ss_SZ
    "ssy" -> ssy
    "st" -> st
    "st-LS" -> st_LS
    "su" -> su
    "su-Latn" -> su_Latn
    "sv" -> sv
    "sv-AX" -> sv_AX
    "sv-FI" -> sv_FI
    "sw" -> sw
    "sw-CD" -> sw_CD
    "sw-KE" -> sw_KE
    "sw-UG" -> sw_UG
    "syr" -> syr
    "syr-SY" -> syr_SY
    "szl" -> szl
    "ta" -> ta
    "ta-LK" -> ta_LK
    "ta-MY" -> ta_MY
    "ta-SG" -> ta_SG
    "te" -> te
    "teo" -> teo
    "teo-KE" -> teo_KE
    "tg" -> tg
    "th" -> th
    "ti" -> ti
    "ti-ER" -> ti_ER
    "tig" -> tig
    "tk" -> tk
    "tn" -> tn
    "tn-BW" -> tn_BW
    "to" -> to
    "tok" -> tok
    "tpi" -> tpi
    "tr" -> tr
    "tr-CY" -> tr_CY
    "trv" -> trv
    "trw" -> trw
    "ts" -> ts
    "tt" -> tt
    "twq" -> twq
    "tyv" -> tyv
    "tzm" -> tzm
    "ug" -> ug
    "uk" -> uk
    "und" -> und
    "ur" -> ur
    "ur-IN" -> ur_IN
    "uz" -> uz
    "uz-Arab" -> uz_Arab
    "uz-Cyrl" -> uz_Cyrl
    "uz-Latn" -> uz_Latn
    "vai" -> vai
    "vai-Latn" -> vai_Latn
    "vai-Vaii" -> vai_Vaii
    "ve" -> ve
    "vec" -> vec
    "vi" -> vi
    "vmw" -> vmw
    "vo" -> vo
    "vun" -> vun
    "wa" -> wa
    "wae" -> wae
    "wal" -> wal
    "wbp" -> wbp
    "wo" -> wo
    "xh" -> xh
    "xnr" -> xnr
    "xog" -> xog
    "yav" -> yav
    "yi" -> yi
    "yo" -> yo
    "yo-BJ" -> yo_BJ
    "yrl" -> yrl
    "yrl-CO" -> yrl_CO
    "yrl-VE" -> yrl_VE
    "yue" -> yue
    "yue-Hans" -> yue_Hans
    "yue-Hant" -> yue_Hant
    "yue-Hant-CN" -> yue_Hant_CN
    "za" -> za
    "zgh" -> zgh
    "zh" -> zh
    "zh-Hans" -> zh_Hans
    "zh-Hans-HK" -> zh_Hans_HK
    "zh-Hans-MO" -> zh_Hans_MO
    "zh-Hans-MY" -> zh_Hans_MY
    "zh-Hans-SG" -> zh_Hans_SG
    "zh-Hant" -> zh_Hant
    "zh-Hant-HK" -> zh_Hant_HK
    "zh-Hant-MO" -> zh_Hant_MO
    "zh-Hant-MY" -> zh_Hant_MY
    "zh-Latn" -> zh_Latn
    "zu" -> zu
    else -> null
  }
}
