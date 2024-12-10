package net.codinux.i18n

import kotlin.Int
import kotlin.String

/**
 * @param code Either alpha-2 tor alpha-3 ISO code or numeric UN M.49 code.
 * @param alpha2Code alpha-2 two-letter country codes are "most prominently for the Internet's country code top-level
 * domains (with a few exceptions). They are also used as country identifiers extending the postal
 * code when appropriate within the international postal system for paper mail."
 *
 * User-assigned codes are: AA, QM to QZ, XA to XZ, and ZZ.
 * These can be freely used and will never be part of the standard.
 * @param alpha3Code alpha-3 three-letter country codes "allow a better visual association between the codes and the
 * country names than the alpha-2 codes. They represent countries, dependent territories, and special
 * areas of geographical interest. (...) They are used most prominently in ISO/IEC 7501-1 for
 * machine-readable passports."
 *
 * User-assigned codes are: AAA to AAZ, QMA to QZZ, XAA to XZZ, and ZZA to ZZZ.
 * These can be freely used and will never be part of the standard.
 * @param numericCode ISO 3166-1 `numeric` codes are three-digit country codes that originate from
 * [UN M.49](https://en.wikipedia.org/wiki/UN_M.49) standard, with the advantage of script (writing system)
 * independence, and hence useful for people or systems using non-Latin scripts such as Arabic or Chinese.
 *
 * The UN M.49 contains also codes for geographical and political regions like a continent and therefore
 * allow for hierarchical mapping of regions.
 *
 * User-assigned codes range from 900 to 999. These are reserved for users to add custom geographical names 
 * in their applications and will never be used by the ISO 3166 standard.
 * @param numericCodeAsString The value of [numericCode] as String, padded with zero to three digits.
 */
enum class Region(
  val code: String,
  val alpha2Code: String?,
  val alpha3Code: String?,
  val numericCode: Int?,
  val numericCodeAsString: String?,
) {
  World("001", null, null, 1, "001"),
  Africa("002", null, null, 2, "002"),
  NorthAmerica("003", null, null, 3, "003"),
  SouthAmerica("005", null, null, 5, "005"),
  Oceania("009", null, null, 9, "009"),
  WesternAfrica("011", null, null, 11, "011"),
  CentralAmerica("013", null, null, 13, "013"),
  EasternAfrica("014", null, null, 14, "014"),
  NorthernAfrica("015", null, null, 15, "015"),
  MiddleAfrica("017", null, null, 17, "017"),
  SouthernAfrica("018", null, null, 18, "018"),
  Americas("019", null, null, 19, "019"),
  NorthernAmerica("021", null, null, 21, "021"),
  Caribbean("029", null, null, 29, "029"),
  EasternAsia("030", null, null, 30, "030"),
  SouthernAsia("034", null, null, 34, "034"),
  SoutheastAsia("035", null, null, 35, "035"),
  SouthernEurope("039", null, null, 39, "039"),
  Australasia("053", null, null, 53, "053"),
  Melanesia("054", null, null, 54, "054"),
  MicronesianRegion("057", null, null, 57, "057"),
  Polynesia("061", null, null, 61, "061"),
  Asia("142", null, null, 142, "142"),
  CentralAsia("143", null, null, 143, "143"),
  WesternAsia("145", null, null, 145, "145"),
  Europe("150", null, null, 150, "150"),
  EasternEurope("151", null, null, 151, "151"),
  NorthernEurope("154", null, null, 154, "154"),
  WesternEurope("155", null, null, 155, "155"),
  SubSaharanAfrica("202", null, null, 202, "202"),
  LatinAmerica("419", null, null, 419, "419"),
  AscensionIsland("AC", "AC", "ASC", 654, "654"),
  Andorra("AD", "AD", "AND", 20, "020"),
  UnitedArabEmirates("AE", "AE", "ARE", 784, "784"),
  Afghanistan("AF", "AF", "AFG", 4, "004"),
  AntiguaAndBarbuda("AG", "AG", "ATG", 28, "028"),
  Anguilla("AI", "AI", "AIA", 660, "660"),
  Albania("AL", "AL", "ALB", 8, "008"),
  Armenia("AM", "AM", "ARM", 51, "051"),
  Angola("AO", "AO", "AGO", 24, "024"),
  Antarctica("AQ", "AQ", "ATA", 10, "010"),
  Argentina("AR", "AR", "ARG", 32, "032"),
  AmericanSamoa("AS", "AS", "ASM", 16, "016"),
  Austria("AT", "AT", "AUT", 40, "040"),
  Australia("AU", "AU", "AUS", 36, "036"),
  Aruba("AW", "AW", "ABW", 533, "533"),
  AlandIslands("AX", "AX", "ALA", 248, "248"),
  Azerbaijan("AZ", "AZ", "AZE", 31, "031"),
  BosniaAndHerzegovina("BA", "BA", "BIH", 70, "070"),
  Barbados("BB", "BB", "BRB", 52, "052"),
  Bangladesh("BD", "BD", "BGD", 50, "050"),
  Belgium("BE", "BE", "BEL", 56, "056"),
  BurkinaFaso("BF", "BF", "BFA", 854, "854"),
  Bulgaria("BG", "BG", "BGR", 100, "100"),
  Bahrain("BH", "BH", "BHR", 48, "048"),
  Burundi("BI", "BI", "BDI", 108, "108"),
  Benin("BJ", "BJ", "BEN", 204, "204"),
  SaintBarthelemy("BL", "BL", "BLM", 652, "652"),
  Bermuda("BM", "BM", "BMU", 60, "060"),
  Brunei("BN", "BN", "BRN", 96, "096"),
  Bolivia("BO", "BO", "BOL", 68, "068"),
  CaribbeanNetherlands("BQ", "BQ", "BES", 535, "535"),
  Brazil("BR", "BR", "BRA", 76, "076"),
  Bahamas("BS", "BS", "BHS", 44, "044"),
  Bhutan("BT", "BT", "BTN", 64, "064"),
  BouvetIsland("BV", "BV", "BVT", 74, "074"),
  Botswana("BW", "BW", "BWA", 72, "072"),
  Belarus("BY", "BY", "BLR", 112, "112"),
  Belize("BZ", "BZ", "BLZ", 84, "084"),
  Canada("CA", "CA", "CAN", 124, "124"),
  CocosKeelingIslands("CC", "CC", "CCK", 166, "166"),
  CongoDemocraticRepublic("CD", "CD", "COD", 180, "180"),
  CentralAfricanRepublic("CF", "CF", "CAF", 140, "140"),
  Congo("CG", "CG", "COG", 178, "178"),
  Switzerland("CH", "CH", "CHE", 756, "756"),
  CotedIvoire("CI", "CI", "CIV", 384, "384"),
  CookIslands("CK", "CK", "COK", 184, "184"),
  Chile("CL", "CL", "CHL", 152, "152"),
  Cameroon("CM", "CM", "CMR", 120, "120"),
  China("CN", "CN", "CHN", 156, "156"),
  Colombia("CO", "CO", "COL", 170, "170"),
  ClippertonIsland("CP", "CP", "CPT", null, null),
  Sark("CQ", "CQ", null, null, null),
  CostaRica("CR", "CR", "CRI", 188, "188"),
  Cuba("CU", "CU", "CUB", 192, "192"),
  CapeVerde("CV", "CV", "CPV", 132, "132"),
  Curacao("CW", "CW", "CUW", 531, "531"),
  ChristmasIsland("CX", "CX", "CXR", 162, "162"),
  Cyprus("CY", "CY", "CYP", 196, "196"),
  Czechia("CZ", "CZ", "CZE", 203, "203"),
  Germany("DE", "DE", "DEU", 276, "276"),
  DiegoGarcia("DG", "DG", "DGA", null, null),
  Djibouti("DJ", "DJ", "DJI", 262, "262"),
  Denmark("DK", "DK", "DNK", 208, "208"),
  Dominica("DM", "DM", "DMA", 212, "212"),
  DominicanRepublic("DO", "DO", "DOM", 214, "214"),
  Algeria("DZ", "DZ", "DZA", 12, "012"),
  CeutaAndMelilla("EA", "EA", null, null, null),
  Ecuador("EC", "EC", "ECU", 218, "218"),
  Estonia("EE", "EE", "EST", 233, "233"),
  Egypt("EG", "EG", "EGY", 818, "818"),
  WesternSahara("EH", "EH", "ESH", 732, "732"),
  Eritrea("ER", "ER", "ERI", 232, "232"),
  Spain("ES", "ES", "ESP", 724, "724"),
  Ethiopia("ET", "ET", "ETH", 231, "231"),
  EuropeanUnion("EU", "EU", "QUU", 967, "967"),
  Eurozone("EZ", "EZ", null, null, null),
  Finland("FI", "FI", "FIN", 246, "246"),
  Fiji("FJ", "FJ", "FJI", 242, "242"),
  FalklandIslands("FK", "FK", "FLK", 238, "238"),
  Micronesia("FM", "FM", "FSM", 583, "583"),
  FaroeIslands("FO", "FO", "FRO", 234, "234"),
  France("FR", "FR", "FRA", 250, "250"),
  Gabon("GA", "GA", "GAB", 266, "266"),
  UnitedKingdom("GB", "GB", "GBR", 826, "826"),
  Grenada("GD", "GD", "GRD", 308, "308"),
  Georgia("GE", "GE", "GEO", 268, "268"),
  FrenchGuiana("GF", "GF", "GUF", 254, "254"),
  Guernsey("GG", "GG", "GGY", 831, "831"),
  Ghana("GH", "GH", "GHA", 288, "288"),
  Gibraltar("GI", "GI", "GIB", 292, "292"),
  Greenland("GL", "GL", "GRL", 304, "304"),
  Gambia("GM", "GM", "GMB", 270, "270"),
  Guinea("GN", "GN", "GIN", 324, "324"),
  Guadeloupe("GP", "GP", "GLP", 312, "312"),
  EquatorialGuinea("GQ", "GQ", "GNQ", 226, "226"),
  Greece("GR", "GR", "GRC", 300, "300"),
  SouthGeorgiaAndSouthSandwichIslands("GS", "GS", "SGS", 239, "239"),
  Guatemala("GT", "GT", "GTM", 320, "320"),
  Guam("GU", "GU", "GUM", 316, "316"),
  GuineaBissau("GW", "GW", "GNB", 624, "624"),
  Guyana("GY", "GY", "GUY", 328, "328"),
  HongKong("HK", "HK", "HKG", 344, "344"),
  HeardAndMcDonaldIslands("HM", "HM", "HMD", 334, "334"),
  Honduras("HN", "HN", "HND", 340, "340"),
  Croatia("HR", "HR", "HRV", 191, "191"),
  Haiti("HT", "HT", "HTI", 332, "332"),
  Hungary("HU", "HU", "HUN", 348, "348"),
  CanaryIslands("IC", "IC", null, null, null),
  Indonesia("ID", "ID", "IDN", 360, "360"),
  Ireland("IE", "IE", "IRL", 372, "372"),
  Israel("IL", "IL", "ISR", 376, "376"),
  IsleOfMan("IM", "IM", "IMN", 833, "833"),
  India("IN", "IN", "IND", 356, "356"),
  BritishIndianOceanTerritory("IO", "IO", "IOT", 86, "086"),
  Iraq("IQ", "IQ", "IRQ", 368, "368"),
  Iran("IR", "IR", "IRN", 364, "364"),
  Iceland("IS", "IS", "ISL", 352, "352"),
  Italy("IT", "IT", "ITA", 380, "380"),
  Jersey("JE", "JE", "JEY", 832, "832"),
  Jamaica("JM", "JM", "JAM", 388, "388"),
  Jordan("JO", "JO", "JOR", 400, "400"),
  Japan("JP", "JP", "JPN", 392, "392"),
  Kenya("KE", "KE", "KEN", 404, "404"),
  Kyrgyzstan("KG", "KG", "KGZ", 417, "417"),
  Cambodia("KH", "KH", "KHM", 116, "116"),
  Kiribati("KI", "KI", "KIR", 296, "296"),
  Comoros("KM", "KM", "COM", 174, "174"),
  SaintKittsAndNevis("KN", "KN", "KNA", 659, "659"),
  NorthKorea("KP", "KP", "PRK", 408, "408"),
  SouthKorea("KR", "KR", "KOR", 410, "410"),
  Kuwait("KW", "KW", "KWT", 414, "414"),
  CaymanIslands("KY", "KY", "CYM", 136, "136"),
  Kazakhstan("KZ", "KZ", "KAZ", 398, "398"),
  Laos("LA", "LA", "LAO", 418, "418"),
  Lebanon("LB", "LB", "LBN", 422, "422"),
  SaintLucia("LC", "LC", "LCA", 662, "662"),
  Liechtenstein("LI", "LI", "LIE", 438, "438"),
  SriLanka("LK", "LK", "LKA", 144, "144"),
  Liberia("LR", "LR", "LBR", 430, "430"),
  Lesotho("LS", "LS", "LSO", 426, "426"),
  Lithuania("LT", "LT", "LTU", 440, "440"),
  Luxembourg("LU", "LU", "LUX", 442, "442"),
  Latvia("LV", "LV", "LVA", 428, "428"),
  Libya("LY", "LY", "LBY", 434, "434"),
  Morocco("MA", "MA", "MAR", 504, "504"),
  Monaco("MC", "MC", "MCO", 492, "492"),
  Moldova("MD", "MD", "MDA", 498, "498"),
  Montenegro("ME", "ME", "MNE", 499, "499"),
  SaintMartin("MF", "MF", "MAF", 663, "663"),
  Madagascar("MG", "MG", "MDG", 450, "450"),
  MarshallIslands("MH", "MH", "MHL", 584, "584"),
  NorthMacedonia("MK", "MK", "MKD", 807, "807"),
  Mali("ML", "ML", "MLI", 466, "466"),
  MyanmarBurma("MM", "MM", "MMR", 104, "104"),
  Mongolia("MN", "MN", "MNG", 496, "496"),
  Macao("MO", "MO", "MAC", 446, "446"),
  NorthernMarianaIslands("MP", "MP", "MNP", 580, "580"),
  Martinique("MQ", "MQ", "MTQ", 474, "474"),
  Mauritania("MR", "MR", "MRT", 478, "478"),
  Montserrat("MS", "MS", "MSR", 500, "500"),
  Malta("MT", "MT", "MLT", 470, "470"),
  Mauritius("MU", "MU", "MUS", 480, "480"),
  Maldives("MV", "MV", "MDV", 462, "462"),
  Malawi("MW", "MW", "MWI", 454, "454"),
  Mexico("MX", "MX", "MEX", 484, "484"),
  Malaysia("MY", "MY", "MYS", 458, "458"),
  Mozambique("MZ", "MZ", "MOZ", 508, "508"),
  Namibia("NA", "NA", "NAM", 516, "516"),
  NewCaledonia("NC", "NC", "NCL", 540, "540"),
  Niger("NE", "NE", "NER", 562, "562"),
  NorfolkIsland("NF", "NF", "NFK", 574, "574"),
  Nigeria("NG", "NG", "NGA", 566, "566"),
  Nicaragua("NI", "NI", "NIC", 558, "558"),
  Netherlands("NL", "NL", "NLD", 528, "528"),
  Norway("NO", "NO", "NOR", 578, "578"),
  Nepal("NP", "NP", "NPL", 524, "524"),
  Nauru("NR", "NR", "NRU", 520, "520"),
  Niue("NU", "NU", "NIU", 570, "570"),
  NewZealand("NZ", "NZ", "NZL", 554, "554"),
  Oman("OM", "OM", "OMN", 512, "512"),
  Panama("PA", "PA", "PAN", 591, "591"),
  Peru("PE", "PE", "PER", 604, "604"),
  FrenchPolynesia("PF", "PF", "PYF", 258, "258"),
  PapuaNewGuinea("PG", "PG", "PNG", 598, "598"),
  Philippines("PH", "PH", "PHL", 608, "608"),
  Pakistan("PK", "PK", "PAK", 586, "586"),
  Poland("PL", "PL", "POL", 616, "616"),
  SaintPierreAndMiquelon("PM", "PM", "SPM", 666, "666"),
  PitcairnIslands("PN", "PN", "PCN", 612, "612"),
  PuertoRico("PR", "PR", "PRI", 630, "630"),
  Palestine("PS", "PS", "PSE", 275, "275"),
  Portugal("PT", "PT", "PRT", 620, "620"),
  Palau("PW", "PW", "PLW", 585, "585"),
  Paraguay("PY", "PY", "PRY", 600, "600"),
  Qatar("QA", "QA", "QAT", 634, "634"),
  OutlyingOceania("QO", "QO", "QOO", 961, "961"),
  Reunion("RE", "RE", "REU", 638, "638"),
  Romania("RO", "RO", "ROU", 642, "642"),
  Serbia("RS", "RS", "SRB", 688, "688"),
  Russia("RU", "RU", "RUS", 643, "643"),
  Rwanda("RW", "RW", "RWA", 646, "646"),
  SaudiArabia("SA", "SA", "SAU", 682, "682"),
  SolomonIslands("SB", "SB", "SLB", 90, "090"),
  Seychelles("SC", "SC", "SYC", 690, "690"),
  Sudan("SD", "SD", "SDN", 729, "729"),
  Sweden("SE", "SE", "SWE", 752, "752"),
  Singapore("SG", "SG", "SGP", 702, "702"),
  SaintHelena("SH", "SH", "SHN", 654, "654"),
  Slovenia("SI", "SI", "SVN", 705, "705"),
  SvalbardAndJanMayen("SJ", "SJ", "SJM", 744, "744"),
  Slovakia("SK", "SK", "SVK", 703, "703"),
  SierraLeone("SL", "SL", "SLE", 694, "694"),
  SanMarino("SM", "SM", "SMR", 674, "674"),
  Senegal("SN", "SN", "SEN", 686, "686"),
  Somalia("SO", "SO", "SOM", 706, "706"),
  Suriname("SR", "SR", "SUR", 740, "740"),
  SouthSudan("SS", "SS", "SSD", 728, "728"),
  SaoTomeAndPrincipe("ST", "ST", "STP", 678, "678"),
  ElSalvador("SV", "SV", "SLV", 222, "222"),
  SintMaarten("SX", "SX", "SXM", 534, "534"),
  Syria("SY", "SY", "SYR", 760, "760"),
  Eswatini("SZ", "SZ", "SWZ", 748, "748"),
  TristanDaCunha("TA", "TA", "TAA", 654, "654"),
  TurksAndCaicosIslands("TC", "TC", "TCA", 796, "796"),
  Chad("TD", "TD", "TCD", 148, "148"),
  FrenchSouthernTerritories("TF", "TF", "ATF", 260, "260"),
  Togo("TG", "TG", "TGO", 768, "768"),
  Thailand("TH", "TH", "THA", 764, "764"),
  Tajikistan("TJ", "TJ", "TJK", 762, "762"),
  Tokelau("TK", "TK", "TKL", 772, "772"),
  TimorLeste("TL", "TL", "TLS", 626, "626"),
  Turkmenistan("TM", "TM", "TKM", 795, "795"),
  Tunisia("TN", "TN", "TUN", 788, "788"),
  Tonga("TO", "TO", "TON", 776, "776"),
  Turkiye("TR", "TR", "TUR", 792, "792"),
  TrinidadAndTobago("TT", "TT", "TTO", 780, "780"),
  Tuvalu("TV", "TV", "TUV", 798, "798"),
  Taiwan("TW", "TW", "TWN", 158, "158"),
  Tanzania("TZ", "TZ", "TZA", 834, "834"),
  Ukraine("UA", "UA", "UKR", 804, "804"),
  Uganda("UG", "UG", "UGA", 800, "800"),
  USOutlyingIslands("UM", "UM", "UMI", 581, "581"),
  UnitedNations("UN", "UN", null, null, null),
  UnitedStates("US", "US", "USA", 840, "840"),
  Uruguay("UY", "UY", "URY", 858, "858"),
  Uzbekistan("UZ", "UZ", "UZB", 860, "860"),
  VaticanCity("VA", "VA", "VAT", 336, "336"),
  SaintVincentAndGrenadines("VC", "VC", "VCT", 670, "670"),
  Venezuela("VE", "VE", "VEN", 862, "862"),
  BritishVirginIslands("VG", "VG", "VGB", 92, "092"),
  USVirginIslands("VI", "VI", "VIR", 850, "850"),
  Vietnam("VN", "VN", "VNM", 704, "704"),
  Vanuatu("VU", "VU", "VUT", 548, "548"),
  WallisAndFutuna("WF", "WF", "WLF", 876, "876"),
  Samoa("WS", "WS", "WSM", 882, "882"),
  PseudoAccents("XA", "XA", "XAA", 973, "973"),
  PseudoBidi("XB", "XB", "XBB", 974, "974"),
  Kosovo("XK", "XK", "XKK", 983, "983"),
  Yemen("YE", "YE", "YEM", 887, "887"),
  Mayotte("YT", "YT", "MYT", 175, "175"),
  SouthAfrica("ZA", "ZA", "ZAF", 710, "710"),
  Zambia("ZM", "ZM", "ZMB", 894, "894"),
  Zimbabwe("ZW", "ZW", "ZWE", 716, "716"),
  UnknownRegion("ZZ", "ZZ", "ZZZ", 999, "999"),
}
