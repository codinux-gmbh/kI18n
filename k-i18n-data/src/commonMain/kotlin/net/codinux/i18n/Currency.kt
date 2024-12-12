package net.codinux.i18n

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param alpha3Code Uppercase alpha-3 three-letter ISO 4217 currency code.
 * @param numericCode Numeric three-digit ISO 4217 currency code.
 * @param symbol Currency symbol, if available.
 * @param symbolVariant Variant of currency symbol, if available.
 * @param englishName English name of the currency.
 * @param isCurrentCurrency If the currency is a current or historic denomination.
 * @param minorUnit Currency's minor unit (e.g. for Euro and Dollar '2' for 100 Cent, for Yen 0 as there is no minor unit).
 * @param withdrawalDate For historic denominations the date of withdrawal.
 */
enum class Currency(
  val alpha3Code: String,
  val numericCode: Int?,
  val symbol: String?,
  val symbolVariant: String?,
  val englishName: String,
  val isCurrentCurrency: Boolean,
  val minorUnit: Int?,
  val withdrawalDate: String?,
  val countries: List<String>,
) {
  AndorranPeseta("ADP", 20, null, null, "Andorran Peseta", false, null, "2003-07", listOf("ANDORRA")),
  UAEDirham("AED", 784, null, null, "UAE Dirham", true, 2, null, listOf("UNITED ARAB EMIRATES (THE)")),
  AfghaniTill200301("AFA", 4, null, null, "Afghani", false, null, "2003-01", listOf("AFGHANISTAN")),
  Afghani("AFN", 971, null, "؋", "Afghani", true, 2, null, listOf("AFGHANISTAN")),
  OldLek("ALK", 8, null, null, "Old Lek", false, null, "1989-12", listOf("ALBANIA")),
  Lek("ALL", 8, null, null, "Lek", true, 2, null, listOf("ALBANIA")),
  ArmenianDram("AMD", 51, null, "֏", "Armenian Dram", true, 2, null, listOf("ARMENIA")),
  NetherlandsAntilleanGuilder("ANG", 532, null, null, "Netherlands Antillean Guilder", true, 2, null, listOf("CURAÇAO", "NETHERLANDS ANTILLES", "SINT MAARTEN (DUTCH PART)")),
  Kwanza("AOA", 973, null, "Kz", "Kwanza", true, 2, null, listOf("ANGOLA")),
  KwanzaTill199103("AOK", 24, null, null, "Kwanza", false, null, "1991-03", listOf("ANGOLA")),
  NewKwanza("AON", 24, null, null, "New Kwanza", false, null, "2000-02", listOf("ANGOLA")),
  KwanzaReajustado("AOR", 982, null, null, "Kwanza Reajustado", false, null, "2000-02", listOf("ANGOLA")),
  Austral("ARA", 32, null, null, "Austral", false, null, "1992-01", listOf("ARGENTINA")),
  PesoArgentino("ARP", 32, null, null, "Peso Argentino", false, null, "1985-07", listOf("ARGENTINA")),
  ArgentinePeso("ARS", 32, null, "$", "Argentine Peso", true, 2, null, listOf("ARGENTINA")),
  Peso("ARY", 32, null, null, "Peso", false, null, "1989 to 1990", listOf("ARGENTINA")),
  Schilling("ATS", 40, null, null, "Schilling", false, null, "2002-03", listOf("AUSTRIA")),
  AustralianDollar("AUD", 36, "A$", "$", "Australian Dollar", true, 2, null, listOf("AUSTRALIA", "CHRISTMAS ISLAND", "COCOS (KEELING) ISLANDS (THE)", "HEARD ISLAND AND McDONALD ISLANDS", "KIRIBATI", "NAURU", "NORFOLK ISLAND", "TUVALU")),
  ArubanFlorin("AWG", 533, null, null, "Aruban Florin", true, 2, null, listOf("ARUBA")),
  AzerbaijanManatTill200510("AYM", 945, null, null, "Azerbaijan Manat", false, null, "2005-10", listOf("AZERBAIJAN")),
  AzerbaijanianManat("AZM", 31, null, null, "Azerbaijanian Manat", false, null, "2005-12", listOf("AZERBAIJAN")),
  AzerbaijanManat("AZN", 944, null, "₼", "Azerbaijan Manat", true, 2, null, listOf("AZERBAIJAN")),
  Dinar("BAD", 70, null, null, "Dinar", false, null, "1998-07", listOf("BOSNIA AND HERZEGOVINA")),
  ConvertibleMark("BAM", 977, null, "KM", "Convertible Mark", true, 2, null, listOf("BOSNIA AND HERZEGOVINA")),
  BarbadosDollar("BBD", 52, null, "$", "Barbados Dollar", true, 2, null, listOf("BARBADOS")),
  Taka("BDT", 50, null, "৳", "Taka", true, 2, null, listOf("BANGLADESH")),
  ConvertibleFranc("BEC", 993, null, null, "Convertible Franc", false, null, "1990-03", listOf("BELGIUM")),
  BelgianFranc("BEF", 56, null, null, "Belgian Franc", false, null, "2002-03", listOf("BELGIUM")),
  FinancialFranc("BEL", 992, null, null, "Financial Franc", false, null, "1990-03", listOf("BELGIUM")),
  LevA52("BGJ", 100, null, null, "Lev A/52", false, null, "1989 to 1990", listOf("BULGARIA")),
  LevA62("BGK", 100, null, null, "Lev A/62", false, null, "1989 to 1990", listOf("BULGARIA")),
  Lev("BGL", 100, null, null, "Lev", false, null, "2003-11", listOf("BULGARIA")),
  BulgarianLev("BGN", 975, null, null, "Bulgarian Lev", true, 2, null, listOf("BULGARIA")),
  BahrainiDinar("BHD", 48, null, null, "Bahraini Dinar", true, 3, null, listOf("BAHRAIN")),
  BurundiFranc("BIF", 108, null, null, "Burundi Franc", true, 0, null, listOf("BURUNDI")),
  BermudianDollar("BMD", 60, null, "$", "Bermudian Dollar", true, 2, null, listOf("BERMUDA")),
  BruneiDollar("BND", 96, null, "$", "Brunei Dollar", true, 2, null, listOf("BRUNEI DARUSSALAM")),
  Boliviano("BOB", 68, null, "Bs", "Boliviano", true, 2, null, listOf("BOLIVIA (PLURINATIONAL STATE OF)")),
  PesoBoliviano("BOP", 68, null, null, "Peso boliviano", false, null, "1987-02", listOf("BOLIVIA")),
  Mvdol("BOV", 984, null, null, "Mvdol", true, 2, null, listOf("BOLIVIA (PLURINATIONAL STATE OF)")),
  CruzeiroTill198603("BRB", 76, null, null, "Cruzeiro", false, null, "1986-03", listOf("BRAZIL")),
  Cruzado("BRC", 76, null, null, "Cruzado", false, null, "1989-02", listOf("BRAZIL")),
  CruzeiroTill199303("BRE", 76, null, null, "Cruzeiro", false, null, "1993-03", listOf("BRAZIL")),
  BrazilianReal("BRL", 986, "R$", "R$", "Brazilian Real", true, 2, null, listOf("BRAZIL")),
  NewCruzado("BRN", 76, null, null, "New Cruzado", false, null, "1990-03", listOf("BRAZIL")),
  CruzeiroReal("BRR", 987, null, null, "Cruzeiro Real", false, null, "1994-07", listOf("BRAZIL")),
  BahamianDollar("BSD", 44, null, "$", "Bahamian Dollar", true, 2, null, listOf("BAHAMAS (THE)")),
  Ngultrum("BTN", 64, null, null, "Ngultrum", true, 2, null, listOf("BHUTAN")),
  KyatTill199002("BUK", 104, null, null, "Kyat", false, null, "1990-02", listOf("BURMA ")),
  Pula("BWP", 72, null, "P", "Pula", true, 2, null, listOf("BOTSWANA")),
  BelarusianRubleTill200101("BYB", 112, null, null, "Belarusian Ruble", false, null, "2001-01", listOf("BELARUS")),
  BelarusianRuble("BYN", 933, null, null, "Belarusian Ruble", true, 2, null, listOf("BELARUS")),
  BelarusianRubleTill201701("BYR", 974, null, null, "Belarusian Ruble", false, null, "2017-01", listOf("BELARUS")),
  BelizeDollar("BZD", 84, null, "$", "Belize Dollar", true, 2, null, listOf("BELIZE")),
  CanadianDollar("CAD", 124, "CA$", "$", "Canadian Dollar", true, 2, null, listOf("CANADA")),
  CongoleseFranc("CDF", 976, null, null, "Congolese Franc", true, 2, null, listOf("CONGO (THE DEMOCRATIC REPUBLIC OF THE)")),
  WIRFrancForElectronic("CHC", 948, null, null, "WIR Franc (for electronic)", false, null, "2004-11", listOf("SWITZERLAND")),
  WIREuro("CHE", 947, null, null, "WIR Euro", true, 2, null, listOf("SWITZERLAND")),
  SwissFranc("CHF", 756, null, null, "Swiss Franc", true, 2, null, listOf("LIECHTENSTEIN", "SWITZERLAND")),
  WIRFranc("CHW", 948, null, null, "WIR Franc", true, 2, null, listOf("SWITZERLAND")),
  UnidadDeFomento("CLF", 990, null, null, "Unidad de Fomento", true, 4, null, listOf("CHILE")),
  ChileanPeso("CLP", 152, null, "$", "Chilean Peso", true, 0, null, listOf("CHILE")),
  YuanRenminbi("CNY", 156, "CN¥", "¥", "Yuan Renminbi", true, 2, null, listOf("CHINA")),
  ColombianPeso("COP", 170, null, "$", "Colombian Peso", true, 2, null, listOf("COLOMBIA")),
  UnidadDeValorReal("COU", 970, null, null, "Unidad de Valor Real", true, 2, null, listOf("COLOMBIA")),
  CostaRicanColon("CRC", 188, null, "₡", "Costa Rican Colon", true, 2, null, listOf("COSTA RICA")),
  SerbianDinarTill200610("CSD", 891, null, null, "Serbian Dinar", false, null, "2006-10", listOf("SERBIA AND MONTENEGRO")),
  KronaA53("CSJ", 203, null, null, "Krona A/53", false, null, "1989 to 1990", listOf("CZECHOSLOVAKIA")),
  Koruna("CSK", 200, null, null, "Koruna", false, null, "1993-03", listOf("CZECHOSLOVAKIA")),
  PesoConvertible("CUC", 931, null, "$", "Peso Convertible", true, 2, null, listOf("CUBA")),
  CubanPeso("CUP", 192, null, "$", "Cuban Peso", true, 2, null, listOf("CUBA")),
  CaboVerdeEscudo("CVE", 132, null, null, "Cabo Verde Escudo", true, 2, null, listOf("CABO VERDE")),
  CyprusPound("CYP", 196, null, null, "Cyprus Pound", false, null, "2008-01", listOf("CYPRUS")),
  CzechKoruna("CZK", 203, null, "Kč", "Czech Koruna", true, 2, null, listOf("CZECHIA")),
  MarkDerDDR("DDM", 278, null, null, "Mark der DDR", false, null, "1990-07 to 1990-09", listOf("GERMAN DEMOCRATIC REPUBLIC")),
  DeutscheMark("DEM", 276, null, null, "Deutsche Mark", false, null, "2002-03", listOf("GERMANY")),
  DjiboutiFranc("DJF", 262, null, null, "Djibouti Franc", true, 0, null, listOf("DJIBOUTI")),
  DanishKrone("DKK", 208, null, "kr", "Danish Krone", true, 2, null, listOf("DENMARK", "FAROE ISLANDS (THE)", "GREENLAND")),
  DominicanPeso("DOP", 214, null, "$", "Dominican Peso", true, 2, null, listOf("DOMINICAN REPUBLIC (THE)")),
  AlgerianDinar("DZD", 12, null, null, "Algerian Dinar", true, 2, null, listOf("ALGERIA")),
  SucreTill200009("ECS", 218, null, null, "Sucre", false, null, "2000-09", listOf("ECUADOR")),
  UnidadDeValorConstanteUVC("ECV", 983, null, null, "Unidad de Valor Constante (UVC)", false, null, "2000-09", listOf("ECUADOR")),
  Kroon("EEK", 233, null, null, "Kroon", false, null, "2011-01", listOf("ESTONIA")),
  EgyptianPound("EGP", 818, null, "E£", "Egyptian Pound", true, 2, null, listOf("EGYPT")),
  Nakfa("ERN", 232, null, null, "Nakfa", true, 2, null, listOf("ERITREA")),
  SpanishPeseta1978To1981("ESA", 996, null, null, "Spanish Peseta", false, null, "1978 to 1981", listOf("SPAIN")),
  AAccountConvertiblePesetaAccount("ESB", 995, null, null, "\"A\" Account (convertible Peseta Account)", false, null, "1994-12", listOf("SPAIN")),
  SpanishPesetaTill200203("ESP", 724, null, "₧", "Spanish Peseta", false, null, "2002-03", listOf("ANDORRA", "SPAIN")),
  EthiopianBirr("ETB", 230, null, null, "Ethiopian Birr", true, 2, null, listOf("ETHIOPIA")),
  Euro("EUR", 978, "€", "€", "Euro", true, 2, null, listOf("ANDORRA", "AUSTRIA", "BELGIUM", "CROATIA", "CYPRUS", "ESTONIA", "EUROPEAN UNION", "FINLAND", "FRANCE", "FRENCH GUIANA", "FRENCH SOUTHERN TERRITORIES (THE)", "GERMANY", "GREECE", "GUADELOUPE", "HOLY SEE (THE)", "IRELAND", "ITALY", "LATVIA", "LITHUANIA", "LUXEMBOURG", "MALTA", "MARTINIQUE", "MAYOTTE", "MONACO", "MONTENEGRO", "NETHERLANDS (THE)", "PORTUGAL", "RÉUNION", "SAINT BARTHÉLEMY", "SAINT MARTIN (FRENCH PART)", "SAINT PIERRE AND MIQUELON", "SAN MARINO", "SERBIA AND MONTENEGRO", "SLOVAKIA", "SLOVENIA", "SPAIN", "ÅLAND ISLANDS")),
  Markka("FIM", 246, null, null, "Markka", false, null, "2002-03", listOf("FINLAND", "ÅLAND ISLANDS")),
  FijiDollar("FJD", 242, null, "$", "Fiji Dollar", true, 2, null, listOf("FIJI")),
  FalklandIslandsPound("FKP", 238, null, "£", "Falkland Islands Pound", true, 2, null, listOf("FALKLAND ISLANDS (THE) [MALVINAS]")),
  FrenchFranc("FRF", 250, null, null, "French Franc", false, null, "2002-03", listOf("ANDORRA", "FRANCE", "FRENCH  GUIANA", "FRENCH SOUTHERN TERRITORIES", "GUADELOUPE", "MARTINIQUE", "MAYOTTE", "MONACO", "RÉUNION", "SAINT MARTIN", "SAINT PIERRE AND MIQUELON", "SAINT-BARTHÉLEMY")),
  PoundSterling("GBP", 826, "£", "£", "Pound Sterling", true, 2, null, listOf("GUERNSEY", "ISLE OF MAN", "JERSEY", "UNITED KINGDOM OF GREAT BRITAIN AND NORTHERN IRELAND (THE)")),
  GeorgianCoupon("GEK", 268, null, null, "Georgian Coupon", false, null, "1995-10", listOf("GEORGIA")),
  Lari("GEL", 981, null, "₾", "Lari", true, 2, null, listOf("GEORGIA")),
  Cedi("GHC", 288, null, null, "Cedi", false, null, "2008-01", listOf("GHANA")),
  GhanaCediTill200706("GHP", 939, null, null, "Ghana Cedi", false, null, "2007-06", listOf("GHANA")),
  GhanaCedi("GHS", 936, null, "GH₵", "Ghana Cedi", true, 2, null, listOf("GHANA")),
  GibraltarPound("GIP", 292, null, "£", "Gibraltar Pound", true, 2, null, listOf("GIBRALTAR")),
  Dalasi("GMD", 270, null, null, "Dalasi", true, 2, null, listOf("GAMBIA (THE)")),
  SyliTill198912("GNE", 324, null, null, "Syli", false, null, "1989-12", listOf("GUINEA")),
  GuineanFranc("GNF", 324, null, "FG", "Guinean Franc", true, 0, null, listOf("GUINEA")),
  SyliTill198602("GNS", 324, null, null, "Syli", false, null, "1986-02", listOf("GUINEA")),
  Ekwele("GQE", 226, null, null, "Ekwele", false, null, "1986-06", listOf("EQUATORIAL GUINEA")),
  Drachma("GRD", 300, null, null, "Drachma", false, null, "2002-03", listOf("GREECE")),
  Quetzal("GTQ", 320, null, "Q", "Quetzal", true, 2, null, listOf("GUATEMALA")),
  GuineaEscudo("GWE", 624, null, null, "Guinea Escudo", false, null, "1978 to 1981", listOf("GUINEA-BISSAU")),
  GuineaBissauPeso("GWP", 624, null, null, "Guinea-Bissau Peso", false, null, "1997-05", listOf("GUINEA-BISSAU")),
  GuyanaDollar("GYD", 328, null, "$", "Guyana Dollar", true, 2, null, listOf("GUYANA")),
  HongKongDollar("HKD", 344, "HK$", "$", "Hong Kong Dollar", true, 2, null, listOf("HONG KONG")),
  Lempira("HNL", 340, null, "L", "Lempira", true, 2, null, listOf("HONDURAS")),
  CroatianDinar("HRD", 191, null, null, "Croatian Dinar", false, null, "1995-01", listOf("CROATIA")),
  CroatianKuna("HRK", 191, null, "kn", "Croatian Kuna", false, null, "2015-06", listOf("CROATIA")),
  Gourde("HTG", 332, null, null, "Gourde", true, 2, null, listOf("HAITI")),
  Forint("HUF", 348, null, "Ft", "Forint", true, 2, null, listOf("HUNGARY")),
  Rupiah("IDR", 360, null, "Rp", "Rupiah", true, 2, null, listOf("INDONESIA", "TIMOR-LESTE")),
  IrishPound("IEP", 372, null, null, "Irish Pound", false, null, "2002-03", listOf("IRELAND")),
  Pound("ILP", 376, null, null, "Pound", false, null, "1978 to 1981", listOf("ISRAEL")),
  OldShekel("ILR", 376, null, null, "Old Shekel", false, null, "1989 to 1990", listOf("ISRAEL")),
  NewIsraeliSheqel("ILS", 376, "₪", "₪", "New Israeli Sheqel", true, 2, null, listOf("ISRAEL")),
  IndianRupee("INR", 356, "₹", "₹", "Indian Rupee", true, 2, null, listOf("BHUTAN", "INDIA")),
  IraqiDinar("IQD", 368, null, null, "Iraqi Dinar", true, 3, null, listOf("IRAQ")),
  IranianRial("IRR", 364, null, null, "Iranian Rial", true, 2, null, listOf("IRAN (ISLAMIC REPUBLIC OF)")),
  OldKrona("ISJ", 352, null, null, "Old Krona", false, null, "1989 to 1990", listOf("ICELAND")),
  IcelandKrona("ISK", 352, null, "kr", "Iceland Krona", true, 0, null, listOf("ICELAND")),
  ItalianLira("ITL", 380, null, null, "Italian Lira", false, null, "2002-03", listOf("HOLY SEE (VATICAN CITY STATE)", "ITALY", "SAN MARINO")),
  JamaicanDollar("JMD", 388, null, "$", "Jamaican Dollar", true, 2, null, listOf("JAMAICA")),
  JordanianDinar("JOD", 400, null, null, "Jordanian Dinar", true, 3, null, listOf("JORDAN")),
  Yen("JPY", 392, "¥", "¥", "Yen", true, 0, null, listOf("JAPAN")),
  KenyanShilling("KES", 404, null, null, "Kenyan Shilling", true, 2, null, listOf("KENYA")),
  Som("KGS", 417, null, "⃀", "Som", true, 2, null, listOf("KYRGYZSTAN")),
  Riel("KHR", 116, null, "៛", "Riel", true, 2, null, listOf("CAMBODIA")),
  ComorianFranc("KMF", 174, null, "CF", "Comorian Franc ", true, 0, null, listOf("COMOROS (THE)")),
  NorthKoreanWon("KPW", 408, null, "₩", "North Korean Won", true, 2, null, listOf("KOREA (THE DEMOCRATIC PEOPLE’S REPUBLIC OF)")),
  Won("KRW", 410, "₩", "₩", "Won", true, 0, null, listOf("KOREA (THE REPUBLIC OF)")),
  KuwaitiDinar("KWD", 414, null, null, "Kuwaiti Dinar", true, 3, null, listOf("KUWAIT")),
  CaymanIslandsDollar("KYD", 136, null, "$", "Cayman Islands Dollar", true, 2, null, listOf("CAYMAN ISLANDS (THE)")),
  Tenge("KZT", 398, null, "₸", "Tenge", true, 2, null, listOf("KAZAKHSTAN")),
  PathetLaoKip("LAJ", 418, null, null, "Pathet Lao Kip", false, null, "1979-12", listOf("LAO")),
  LaoKip("LAK", 418, null, "₭", "Lao Kip", true, 2, null, listOf("LAO PEOPLE’S DEMOCRATIC REPUBLIC (THE)")),
  LebanesePound("LBP", 422, null, "L£", "Lebanese Pound", true, 2, null, listOf("LEBANON")),
  SriLankaRupee("LKR", 144, null, "Rs", "Sri Lanka Rupee", true, 2, null, listOf("SRI LANKA")),
  LiberianDollar("LRD", 430, null, "$", "Liberian Dollar", true, 2, null, listOf("LIBERIA")),
  Loti("LSL", 426, null, null, "Loti", true, 2, null, listOf("LESOTHO")),
  LotiTill198505("LSM", 426, null, null, "Loti", false, null, "1985-05", listOf("LESOTHO")),
  LithuanianLitas("LTL", 440, null, "Lt", "Lithuanian Litas", false, null, "2014-12", listOf("LITHUANIA")),
  Talonas("LTT", 440, null, null, "Talonas", false, null, "1993-07", listOf("LITHUANIA")),
  LuxembourgConvertibleFranc("LUC", 989, null, null, "Luxembourg Convertible Franc", false, null, "1990-03", listOf("LUXEMBOURG")),
  LuxembourgFranc("LUF", 442, null, null, "Luxembourg Franc", false, null, "2002-03", listOf("LUXEMBOURG")),
  LuxembourgFinancialFranc("LUL", 988, null, null, "Luxembourg Financial Franc", false, null, "1990-03", listOf("LUXEMBOURG")),
  LatvianLats("LVL", 428, null, "Ls", "Latvian Lats", false, null, "2014-01", listOf("LATVIA")),
  LatvianRuble("LVR", 428, null, null, "Latvian Ruble", false, null, "1994-12", listOf("LATVIA")),
  LibyanDinar("LYD", 434, null, null, "Libyan Dinar", true, 3, null, listOf("LIBYA")),
  MoroccanDirham("MAD", 504, null, null, "Moroccan Dirham", true, 2, null, listOf("MOROCCO", "WESTERN SAHARA")),
  MoldovanLeu("MDL", 498, null, null, "Moldovan Leu", true, 2, null, listOf("MOLDOVA (THE REPUBLIC OF)")),
  MalagasyAriary("MGA", 969, null, "Ar", "Malagasy Ariary", true, 2, null, listOf("MADAGASCAR")),
  MalagasyFranc("MGF", 450, null, null, "Malagasy Franc", false, null, "2004-12", listOf("MADAGASCAR")),
  Denar("MKD", 807, null, null, "Denar", true, 2, null, listOf("NORTH MACEDONIA")),
  MaliFranc("MLF", 466, null, null, "Mali Franc", false, null, "1984-11", listOf("MALI")),
  Kyat("MMK", 104, null, "K", "Kyat", true, 2, null, listOf("MYANMAR")),
  Tugrik("MNT", 496, null, "₮", "Tugrik", true, 2, null, listOf("MONGOLIA")),
  Pataca("MOP", 446, null, null, "Pataca", true, 2, null, listOf("MACAO")),
  OuguiyaTill201712("MRO", 478, null, null, "Ouguiya", false, null, "2017-12", listOf("MAURITANIA")),
  Ouguiya("MRU", 929, null, null, "Ouguiya", true, 2, null, listOf("MAURITANIA")),
  MalteseLira("MTL", 470, null, null, "Maltese Lira", false, null, "2008-01", listOf("MALTA")),
  MaltesePound("MTP", 470, null, null, "Maltese Pound", false, null, "1983-06", listOf("MALTA")),
  MauritiusRupee("MUR", 480, null, "Rs", "Mauritius Rupee", true, 2, null, listOf("MAURITIUS")),
  MaldiveRupee("MVQ", 462, null, null, "Maldive Rupee", false, null, "1989-12", listOf("MALDIVES")),
  Rufiyaa("MVR", 462, null, null, "Rufiyaa", true, 2, null, listOf("MALDIVES")),
  MalawiKwacha("MWK", 454, null, null, "Malawi Kwacha", true, 2, null, listOf("MALAWI")),
  MexicanPeso("MXN", 484, "MX$", "$", "Mexican Peso", true, 2, null, listOf("MEXICO")),
  MexicanPesoTill199301("MXP", 484, null, null, "Mexican Peso", false, null, "1993-01", listOf("MEXICO")),
  MexicanUnidadDeInversionUDI("MXV", 979, null, null, "Mexican Unidad de Inversion (UDI)", true, 2, null, listOf("MEXICO")),
  MalaysianRinggit("MYR", 458, null, "RM", "Malaysian Ringgit", true, 2, null, listOf("MALAYSIA")),
  MozambiqueEscudo("MZE", 508, null, null, "Mozambique Escudo", false, null, "1978 to 1981", listOf("MOZAMBIQUE")),
  MozambiqueMeticalTill200606("MZM", 508, null, null, "Mozambique Metical", false, null, "2006-06", listOf("MOZAMBIQUE")),
  MozambiqueMetical("MZN", 943, null, null, "Mozambique Metical", true, 2, null, listOf("MOZAMBIQUE")),
  NamibiaDollar("NAD", 516, null, "$", "Namibia Dollar", true, 2, null, listOf("NAMIBIA")),
  Naira("NGN", 566, null, "₦", "Naira", true, 2, null, listOf("NIGERIA")),
  Cordoba("NIC", 558, null, null, "Cordoba", false, null, "1990-10", listOf("NICARAGUA")),
  CordobaOro("NIO", 558, null, "C$", "Cordoba Oro", true, 2, null, listOf("NICARAGUA")),
  NetherlandsGuilder("NLG", 528, null, null, "Netherlands Guilder", false, null, "2002-03", listOf("NETHERLANDS")),
  NorwegianKrone("NOK", 578, null, "kr", "Norwegian Krone", true, 2, null, listOf("BOUVET ISLAND", "NORWAY", "SVALBARD AND JAN MAYEN")),
  NepaleseRupee("NPR", 524, null, "Rs", "Nepalese Rupee", true, 2, null, listOf("NEPAL")),
  NewZealandDollar("NZD", 554, "NZ$", "$", "New Zealand Dollar", true, 2, null, listOf("COOK ISLANDS (THE)", "NEW ZEALAND", "NIUE", "PITCAIRN", "TOKELAU")),
  RialOmani("OMR", 512, null, null, "Rial Omani", true, 3, null, listOf("OMAN")),
  Balboa("PAB", 590, null, null, "Balboa", true, 2, null, listOf("PANAMA")),
  Sol1989To1990("PEH", 604, null, null, "Sol", false, null, "1989 to 1990", listOf("PERU")),
  Inti("PEI", 604, null, null, "Inti", false, null, "1991-07", listOf("PERU")),
  Sol("PEN", 604, null, null, "Sol", true, 2, null, listOf("PERU")),
  SolTill198602("PES", 604, null, null, "Sol", false, null, "1986-02", listOf("PERU")),
  Kina("PGK", 598, null, null, "Kina", true, 2, null, listOf("PAPUA NEW GUINEA")),
  PhilippinePeso("PHP", 608, "₱", "₱", "Philippine Peso", true, 2, null, listOf("PHILIPPINES (THE)")),
  PakistanRupee("PKR", 586, null, "Rs", "Pakistan Rupee", true, 2, null, listOf("PAKISTAN")),
  Zloty("PLN", 985, null, "zł", "Zloty", true, 2, null, listOf("POLAND")),
  ZlotyTill199701("PLZ", 616, null, null, "Zloty", false, null, "1997-01", listOf("POLAND")),
  PortugueseEscudo("PTE", 620, null, null, "Portuguese Escudo", false, null, "2002-03", listOf("PORTUGAL")),
  Guarani("PYG", 600, null, "₲", "Guarani", true, 0, null, listOf("PARAGUAY")),
  QatariRial("QAR", 634, null, null, "Qatari Rial", true, 2, null, listOf("QATAR")),
  RhodesianDollar1978To1981("RHD", 716, null, null, "Rhodesian Dollar", false, null, "1978 to 1981", listOf("SOUTHERN RHODESIA ")),
  LeuA52("ROK", 642, null, null, "Leu A/52", false, null, "1989 to 1990", listOf("ROMANIA")),
  OldLeu("ROL", 642, null, null, "Old Leu", false, null, "2005-06", listOf("ROMANIA")),
  RomanianLeu("RON", 946, null, "lei", "Romanian Leu", true, 2, null, listOf("ROMANIA")),
  SerbianDinar("RSD", 941, null, null, "Serbian Dinar", true, 2, null, listOf("SERBIA")),
  RussianRuble("RUB", 643, null, "₽", "Russian Ruble", true, 2, null, listOf("RUSSIAN FEDERATION (THE)")),
  RussianRubleTill199408("RUR", 810, null, null, "Russian Ruble", false, null, "1994-08", listOf("ARMENIA", "AZERBAIJAN", "BELARUS", "GEORGIA", "KAZAKHSTAN", "KYRGYZSTAN", "MOLDOVA, REPUBLIC OF", "RUSSIAN FEDERATION", "TAJIKISTAN", "TURKMENISTAN", "UZBEKISTAN")),
  RwandaFranc("RWF", 646, null, "RF", "Rwanda Franc", true, 0, null, listOf("RWANDA")),
  SaudiRiyal("SAR", 682, null, null, "Saudi Riyal", true, 2, null, listOf("SAUDI ARABIA")),
  SolomonIslandsDollar("SBD", 90, null, "$", "Solomon Islands Dollar", true, 2, null, listOf("SOLOMON ISLANDS")),
  SeychellesRupee("SCR", 690, null, null, "Seychelles Rupee", true, 2, null, listOf("SEYCHELLES")),
  SudaneseDinar("SDD", 736, null, null, "Sudanese Dinar", false, null, "2007-07", listOf("SUDAN")),
  SudanesePound("SDG", 938, null, null, "Sudanese Pound", true, 2, null, listOf("SOUTH SUDAN", "SUDAN (THE)")),
  SudanesePoundTill199806("SDP", 736, null, null, "Sudanese Pound", false, null, "1998-06", listOf("SUDAN")),
  SwedishKrona("SEK", 752, null, "kr", "Swedish Krona", true, 2, null, listOf("SWEDEN")),
  SingaporeDollar("SGD", 702, null, "$", "Singapore Dollar", true, 2, null, listOf("SINGAPORE")),
  SaintHelenaPound("SHP", 654, null, "£", "Saint Helena Pound", true, 2, null, listOf("SAINT HELENA, ASCENSION AND TRISTAN DA CUNHA")),
  Tolar("SIT", 705, null, null, "Tolar", false, null, "2007-01", listOf("SLOVENIA")),
  SlovakKoruna("SKK", 703, null, null, "Slovak Koruna", false, null, "2009-01", listOf("SLOVAKIA")),
  Leone("SLE", 925, null, null, "Leone", true, 2, null, listOf("SIERRA LEONE")),
  LeoneTill202312("SLL", 694, null, null, "Leone", false, null, "2023-12", listOf("SIERRA LEONE")),
  SomaliShilling("SOS", 706, null, null, "Somali Shilling", true, 2, null, listOf("SOMALIA")),
  SurinamDollar("SRD", 968, null, "$", "Surinam Dollar", true, 2, null, listOf("SURINAME")),
  SurinamGuilder("SRG", 740, null, null, "Surinam Guilder", false, null, "2003-12", listOf("SURINAME")),
  SouthSudanesePound("SSP", 728, null, "£", "South Sudanese Pound", true, 2, null, listOf("SOUTH SUDAN")),
  DobraTill201712("STD", 678, null, null, "Dobra", false, null, "2017-12", listOf("SAO TOME AND PRINCIPE")),
  Dobra("STN", 930, null, "Db", "Dobra", true, 2, null, listOf("SAO TOME AND PRINCIPE")),
  Rouble("SUR", 810, null, null, "Rouble", false, null, "1990-12", listOf("UNION OF SOVIET SOCIALIST REPUBLICS")),
  ElSalvadorColon("SVC", 222, null, null, "El Salvador Colon", true, 2, null, listOf("EL SALVADOR")),
  SyrianPound("SYP", 760, null, "£", "Syrian Pound", true, 2, null, listOf("SYRIAN ARAB REPUBLIC")),
  Lilangeni("SZL", 748, null, null, "Lilangeni", true, 2, null, listOf("ESWATINI", "SWAZILAND")),
  Baht("THB", 764, null, "฿", "Baht", true, 2, null, listOf("THAILAND")),
  TajikRuble("TJR", 762, null, null, "Tajik Ruble", false, null, "2001-04", listOf("TAJIKISTAN")),
  Somoni("TJS", 972, null, null, "Somoni", true, 2, null, listOf("TAJIKISTAN")),
  TurkmenistanManat("TMM", 795, null, null, "Turkmenistan Manat", false, null, "2009-01", listOf("TURKMENISTAN")),
  TurkmenistanNewManat("TMT", 934, null, null, "Turkmenistan New Manat", true, 2, null, listOf("TURKMENISTAN")),
  TunisianDinar("TND", 788, null, null, "Tunisian Dinar", true, 3, null, listOf("TUNISIA")),
  Paanga("TOP", 776, null, "T$", "Pa’anga", true, 2, null, listOf("TONGA")),
  TimorEscudo("TPE", 626, null, null, "Timor Escudo", false, null, "2002-11", listOf("TIMOR-LESTE")),
  OldTurkishLira("TRL", 792, null, null, "Old Turkish Lira", false, null, "2005-12", listOf("TURKEY")),
  TurkishLira("TRY", 949, null, "TL", "Turkish Lira", true, 2, null, listOf("TURKEY", "TÜRKİYE")),
  TrinidadAndTobagoDollar("TTD", 780, null, "$", "Trinidad and Tobago Dollar", true, 2, null, listOf("TRINIDAD AND TOBAGO")),
  NewTaiwanDollar("TWD", 901, "NT$", "$", "New Taiwan Dollar", true, 2, null, listOf("TAIWAN (PROVINCE OF CHINA)")),
  TanzanianShilling("TZS", 834, null, null, "Tanzanian Shilling", true, 2, null, listOf("TANZANIA, UNITED REPUBLIC OF")),
  Hryvnia("UAH", 980, null, "₴", "Hryvnia", true, 2, null, listOf("UKRAINE")),
  Karbovanet("UAK", 804, null, null, "Karbovanet", false, null, "1996-09", listOf("UKRAINE")),
  UgandaShillingTill198705("UGS", 800, null, null, "Uganda Shilling", false, null, "1987-05", listOf("UGANDA")),
  OldShilling("UGW", 800, null, null, "Old Shilling", false, null, "1989 to 1990", listOf("UGANDA")),
  UgandaShilling("UGX", 800, null, null, "Uganda Shilling", true, 0, null, listOf("UGANDA")),
  USDollar("USD", 840, "$", "$", "US Dollar", true, 2, null, listOf("AMERICAN SAMOA", "BONAIRE, SINT EUSTATIUS AND SABA", "BRITISH INDIAN OCEAN TERRITORY (THE)", "ECUADOR", "EL SALVADOR", "GUAM", "HAITI", "MARSHALL ISLANDS (THE)", "MICRONESIA (FEDERATED STATES OF)", "NORTHERN MARIANA ISLANDS (THE)", "PALAU", "PANAMA", "PUERTO RICO", "TIMOR-LESTE", "TURKS AND CAICOS ISLANDS (THE)", "UNITED STATES MINOR OUTLYING ISLANDS (THE)", "UNITED STATES OF AMERICA (THE)", "VIRGIN ISLANDS (BRITISH)", "VIRGIN ISLANDS (U.S.)")),
  USDollarNextDay("USN", 997, null, null, "US Dollar (Next day)", true, 2, null, listOf("UNITED STATES OF AMERICA (THE)")),
  USDollarSameDay("USS", 998, null, null, "US Dollar (Same day)", false, null, "2014-03", listOf("UNITED STATES")),
  UruguayPesoEnUnidadesIndexadasUI("UYI", 940, null, null, "Uruguay Peso en Unidades Indexadas (UI)", true, 0, null, listOf("URUGUAY")),
  OldUruguayPeso("UYN", 858, null, null, "Old Uruguay Peso", false, null, "1989-12", listOf("URUGUAY")),
  UruguayanPeso("UYP", 858, null, null, "Uruguayan Peso", false, null, "1993-03", listOf("URUGUAY")),
  PesoUruguayo("UYU", 858, null, "$", "Peso Uruguayo", true, 2, null, listOf("URUGUAY")),
  UnidadPrevisional("UYW", 927, null, null, "Unidad Previsional", true, 4, null, listOf("URUGUAY")),
  UzbekistanSum("UZS", 860, null, null, "Uzbekistan Sum", true, 2, null, listOf("UZBEKISTAN")),
  Bolivar("VEB", 862, null, null, "Bolivar", false, null, "2008-01", listOf("VENEZUELA")),
  BolivarSoberano("VES", 928, null, null, "Bolívar Soberano", true, 2, null, listOf("VENEZUELA (BOLIVARIAN REPUBLIC OF)")),
  BolivarFuerte("VEF", 937, null, "Bs", "Bolivar Fuerte", false, null, "2011-12", listOf("VENEZUELA", "VENEZUELA (BOLIVARIAN REPUBLIC OF)")),
  OldDong("VNC", 704, null, null, "Old Dong", false, null, "1989-1990", listOf("VIETNAM")),
  Dong("VND", 704, "₫", "₫", "Dong", true, 0, null, listOf("VIET NAM")),
  Vatu("VUV", 548, null, null, "Vatu", true, 0, null, listOf("VANUATU")),
  Tala("WST", 882, null, null, "Tala", true, 2, null, listOf("SAMOA")),
  CFAFrancBEAC("XAF", 950, "FCFA", null, "CFA Franc BEAC", true, 0, null, listOf("CAMEROON", "CENTRAL AFRICAN REPUBLIC (THE)", "CHAD", "CONGO (THE)", "EQUATORIAL GUINEA", "GABON")),
  Silver("XAG", 961, null, null, "Silver", true, null, null, listOf("ZZ11_Silver")),
  Gold("XAU", 959, null, null, "Gold", true, null, null, listOf("ZZ08_Gold")),
  BondMarketsUnitEuropeanCompositeUnitEURCO("XBA", 955, null, null, "Bond Markets Unit European Composite Unit (EURCO)", true, null, null, listOf("ZZ01_Bond Markets Unit European_EURCO")),
  BondMarketsUnitEuropeanMonetaryUnitEMU6("XBB", 956, null, null, "Bond Markets Unit European Monetary Unit (E.M.U.-6)", true, null, null, listOf("ZZ02_Bond Markets Unit European_EMU-6")),
  BondMarketsUnitEuropeanUnitOfAccount9EUA9("XBC", 957, null, null, "Bond Markets Unit European Unit of Account 9 (E.U.A.-9)", true, null, null, listOf("ZZ03_Bond Markets Unit European_EUA-9")),
  BondMarketsUnitEuropeanUnitOfAccount17EUA17("XBD", 958, null, null, "Bond Markets Unit European Unit of Account 17 (E.U.A.-17)", true, null, null, listOf("ZZ04_Bond Markets Unit European_EUA-17")),
  EastCaribbeanDollar("XCD", 951, "EC$", "$", "East Caribbean Dollar", true, 2, null, listOf("ANGUILLA", "ANTIGUA AND BARBUDA", "DOMINICA", "GRENADA", "MONTSERRAT", "SAINT KITTS AND NEVIS", "SAINT LUCIA", "SAINT VINCENT AND THE GRENADINES")),
  SDRSpecialDrawingRight("XDR", 960, null, null, "SDR (Special Drawing Right)", true, null, null, listOf("INTERNATIONAL MONETARY FUND (IMF) ")),
  EuropeanCurrencyUnitECU("XEU", 954, null, null, "European Currency Unit (E.C.U)", false, null, "1999-01", listOf("EUROPEAN MONETARY CO-OPERATION FUND (EMCF)")),
  GoldFranc("XFO", null, null, null, "Gold-Franc", false, null, "2006-10", listOf("ZZ01_Gold-Franc")),
  UICFranc("XFU", null, null, null, "UIC-Franc", false, null, "2013-11", listOf("ZZ05_UIC-Franc")),
  CFAFrancBCEAO("XOF", 952, "F CFA", null, "CFA Franc BCEAO", true, 0, null, listOf("BENIN", "BURKINA FASO", "CÔTE D'IVOIRE", "GUINEA-BISSAU", "MALI", "NIGER (THE)", "SENEGAL", "TOGO")),
  Palladium("XPD", 964, null, null, "Palladium", true, null, null, listOf("ZZ09_Palladium")),
  CFPFranc("XPF", 953, "CFPF", null, "CFP Franc", true, 0, null, listOf("FRENCH POLYNESIA", "NEW CALEDONIA", "WALLIS AND FUTUNA")),
  Platinum("XPT", 962, null, null, "Platinum", true, null, null, listOf("ZZ10_Platinum")),
  RINETFundsCode("XRE", null, null, null, "RINET Funds Code", false, null, "1999-11", listOf("ZZ02_RINET Funds Code")),
  Sucre("XSU", 994, null, null, "Sucre", true, null, null, listOf("SISTEMA UNITARIO DE COMPENSACION REGIONAL DE PAGOS 'SUCRE'")),
  CodesSpecificallyReservedForTestingPurposes("XTS", 963, null, null, "Codes specifically reserved for testing purposes", true, null, null, listOf("ZZ06_Testing_Code")),
  ADBUnitOfAccount("XUA", 965, null, null, "ADB Unit of Account", true, null, null, listOf("MEMBER COUNTRIES OF THE AFRICAN DEVELOPMENT BANK GROUP")),
  TheCodesAssignedForTransactionsWhereNoCurrencyIsInvolved("XXX", 999, "¤", null, "The codes assigned for transactions where no currency is involved", true, null, null, listOf("ZZ07_No_Currency")),
  YemeniDinar("YDD", 720, null, null, "Yemeni Dinar", false, null, "1991-09", listOf("YEMEN, DEMOCRATIC")),
  YemeniRial("YER", 886, null, null, "Yemeni Rial", true, 2, null, listOf("YEMEN")),
  NewYugoslavianDinar("YUD", 890, null, null, "New Yugoslavian Dinar", false, null, "1990-01", listOf("YUGOSLAVIA")),
  NewDinar("YUM", 891, null, null, "New Dinar", false, null, "2003-07", listOf("YUGOSLAVIA")),
  YugoslavianDinar("YUN", 890, null, null, "Yugoslavian Dinar", false, null, "1995-11", listOf("YUGOSLAVIA")),
  FinancialRand("ZAL", 991, null, null, "Financial Rand", false, null, "1995-03", listOf("LESOTHO", "SOUTH AFRICA")),
  Rand("ZAR", 710, null, "R", "Rand", true, 2, null, listOf("LESOTHO", "NAMIBIA", "SOUTH AFRICA")),
  ZambianKwachaTill201212("ZMK", 894, null, null, "Zambian Kwacha", false, null, "2012-12", listOf("ZAMBIA")),
  ZambianKwacha("ZMW", 967, null, "ZK", "Zambian Kwacha", true, 2, null, listOf("ZAMBIA")),
  NewZaire("ZRN", 180, null, null, "New Zaire", false, null, "1999-06", listOf("ZAIRE")),
  Zaire("ZRZ", 180, null, null, "Zaire", false, null, "1994-02", listOf("ZAIRE")),
  RhodesianDollarTill198912("ZWC", 716, null, null, "Rhodesian Dollar", false, null, "1989-12", listOf("ZIMBABWE")),
  ZimbabweDollarOld("ZWD", 716, null, null, "Zimbabwe Dollar (old)", false, null, "2006-08", listOf("ZIMBABWE")),
  ZimbabweGold("ZWG", 924, null, null, "Zimbabwe Gold", true, 2, null, listOf("ZIMBABWE")),
  ZimbabweDollar("ZWR", 935, null, null, "Zimbabwe Dollar", false, null, "2009-06", listOf("ZIMBABWE")),
  ZimbabweDollarNew("ZWN", 942, null, null, "Zimbabwe Dollar (new)", false, null, "2006-09", listOf("ZIMBABWE")),
}
