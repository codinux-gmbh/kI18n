package net.codinux.i18n

import kotlin.String

/**
 * Defines all Scripts (writing systems) known to CLDR.
 *
 * @param code Four-letter ISO 15924 code in title case.
 *
 * The codes 900–999 are special codes, aliases or for private use.
 *
 * Special codes:
 * - Qaaa–Qabx (900–949): 50 Codes reserved for private use (for example, Qaag is used to mark Burmese text encoded for the Zawgyi font)
 * - Zsye 993: Emoji
 * - Zinh 994: Code for inherited script
 * - Zmth 995: Mathematical notation
 * - Zsym 996: Symbols
 * - Zxxx 997: Code for unwritten documents
 * - Zyyy 998: Code for undetermined script
 * - Zzzz 999: Code for uncoded script
 *
 * Two four-letter codes are reserved at the request of the Common Locale Data Repository (CLDR) project:
 * - Root: Reserved for the language-neutral base of the CLDR locale tree
 * - True: Reserved for the Boolean value "true")
 * @param englishName English name of the script.
 * @param variantName Optional a variant of the English name of the script (if available).
 * @param originCountry The origin region of the script, if available.
 */
enum class Script(
  val code: String,
  val englishName: String,
  val variantName: String?,
  val originCountry: Region?,
) {
  Adlam("Adlm", "Adlam", null, Region.Guinea),
  Afaka("Afak", "Afaka", null, null),
  CaucasianAlbanian("Aghb", "Caucasian Albanian", null, Region.Azerbaijan),
  Ahom("Ahom", "Ahom", null, Region.India),
  Arabic("Arab", "Arabic", "Perso-Arabic", Region.SaudiArabia),
  Nastaliq("Aran", "Nastaliq", null, null),
  ImperialAramaic("Armi", "Imperial Aramaic", null, Region.Iran),
  Armenian("Armn", "Armenian", null, Region.Armenia),
  Avestan("Avst", "Avestan", null, Region.Iran),
  Balinese("Bali", "Balinese", null, Region.Indonesia),
  Bamum("Bamu", "Bamum", null, Region.Cameroon),
  BassaVah("Bass", "Bassa Vah", null, Region.Liberia),
  Batak("Batk", "Batak", null, Region.Indonesia),
  Bangla("Beng", "Bangla", null, Region.Bangladesh),
  Bhaiksuki("Bhks", "Bhaiksuki", null, Region.India),
  Blissymbols("Blis", "Blissymbols", null, null),
  Bopomofo("Bopo", "Bopomofo", null, Region.China),
  Brahmi("Brah", "Brahmi", null, Region.India),
  Braille("Brai", "Braille", null, Region.France),
  Buginese("Bugi", "Buginese", null, Region.Indonesia),
  Buhid("Buhd", "Buhid", null, Region.Philippines),
  Chakma("Cakm", "Chakma", null, Region.Bangladesh),
  UnifiedCanadianAboriginalSyllabics("Cans", "Unified Canadian Aboriginal Syllabics", "UCAS", Region.Canada),
  Carian("Cari", "Carian", null, Region.Turkiye),
  Cham("Cham", "Cham", null, Region.Vietnam),
  Cherokee("Cher", "Cherokee", null, Region.UnitedStates),
  Chorasmian("Chrs", "Chorasmian", null, Region.Uzbekistan),
  Cirth("Cirt", "Cirth", null, null),
  Coptic("Copt", "Coptic", null, Region.Egypt),
  CyproMinoan("Cpmn", "Cypro-Minoan", null, Region.Cyprus),
  Cypriot("Cprt", "Cypriot", null, Region.Cyprus),
  Cyrillic("Cyrl", "Cyrillic", null, Region.Bulgaria),
  OldChurchSlavonicCyrillic("Cyrs", "Old Church Slavonic Cyrillic", null, null),
  Devanagari("Deva", "Devanagari", null, Region.India),
  DivesAkuru("Diak", "Dives Akuru", null, Region.Maldives),
  Dogra("Dogr", "Dogra", null, Region.India),
  Deseret("Dsrt", "Deseret", null, Region.UnitedStates),
  DuployanShorthand("Dupl", "Duployan shorthand", null, Region.France),
  EgyptianDemotic("Egyd", "Egyptian demotic", null, null),
  EgyptianHieratic("Egyh", "Egyptian hieratic", null, null),
  EgyptianHieroglyphs("Egyp", "Egyptian hieroglyphs", null, Region.Egypt),
  Elbasan("Elba", "Elbasan", null, Region.Albania),
  Elymaic("Elym", "Elymaic", null, Region.Iran),
  Ethiopic("Ethi", "Ethiopic", null, Region.Ethiopia),
  Garay("Gara", "Garay", null, Region.Senegal),
  GeorgianKhutsuri("Geok", "Georgian Khutsuri", null, null),
  Georgian("Geor", "Georgian", null, Region.Georgia),
  Glagolitic("Glag", "Glagolitic", null, Region.Bulgaria),
  GunjalaGondi("Gong", "Gunjala Gondi", null, Region.India),
  MasaramGondi("Gonm", "Masaram Gondi", null, Region.India),
  Gothic("Goth", "Gothic", null, Region.Ukraine),
  Grantha("Gran", "Grantha", null, Region.India),
  Greek("Grek", "Greek", null, Region.Greece),
  Gujarati("Gujr", "Gujarati", null, Region.India),
  GurungKhema("Gukh", "Gurung Khema", null, Region.Nepal),
  Gurmukhi("Guru", "Gurmukhi", null, Region.India),
  HanWithBopomofo("Hanb", "Han with Bopomofo", null, Region.China),
  Hangul("Hang", "Hangul", null, Region.SouthKorea),
  Han("Hani", "Han", null, Region.China),
  Hanunoo("Hano", "Hanunoo", null, Region.Philippines),
  Simplified("Hans", "Simplified", null, Region.China),
  Traditional("Hant", "Traditional", null, Region.China),
  Hatran("Hatr", "Hatran", null, Region.Iraq),
  Hebrew("Hebr", "Hebrew", null, Region.Israel),
  Hiragana("Hira", "Hiragana", null, Region.Japan),
  AnatolianHieroglyphs("Hluw", "Anatolian Hieroglyphs", null, Region.Turkiye),
  PahawhHmong("Hmng", "Pahawh Hmong", null, Region.Laos),
  NyiakengPuachueHmong("Hmnp", "Nyiakeng Puachue Hmong", null, Region.UnitedStates),
  JapaneseSyllabaries("Hrkt", "Japanese syllabaries", null, null),
  OldHungarian("Hung", "Old Hungarian", null, Region.Hungary),
  Indus("Inds", "Indus", null, null),
  OldItalic("Ital", "Old Italic", null, Region.Italy),
  Jamo("Jamo", "Jamo", null, Region.SouthKorea),
  Javanese("Java", "Javanese", null, Region.Indonesia),
  Japanese("Jpan", "Japanese", null, Region.Japan),
  Jurchen("Jurc", "Jurchen", null, null),
  KayahLi("Kali", "Kayah Li", null, Region.MyanmarBurma),
  Katakana("Kana", "Katakana", null, Region.Japan),
  Kawi("Kawi", "Kawi", null, Region.Indonesia),
  Kharoshthi("Khar", "Kharoshthi", null, Region.Pakistan),
  Khmer("Khmr", "Khmer", null, Region.Cambodia),
  Khojki("Khoj", "Khojki", null, Region.India),
  KhitanSmallScript("Kits", "Khitan small script", null, Region.China),
  Kannada("Knda", "Kannada", null, Region.India),
  Korean("Kore", "Korean", null, Region.SouthKorea),
  Kpelle("Kpel", "Kpelle", null, null),
  KiratRai("Krai", "Kirat Rai", null, Region.India),
  Kaithi("Kthi", "Kaithi", null, Region.India),
  Lanna("Lana", "Lanna", null, Region.Thailand),
  Lao("Laoo", "Lao", null, Region.Laos),
  FrakturLatin("Latf", "Fraktur Latin", null, null),
  GaelicLatin("Latg", "Gaelic Latin", null, null),
  Latin("Latn", "Latin", null, Region.Italy),
  Lepcha("Lepc", "Lepcha", null, Region.India),
  Limbu("Limb", "Limbu", null, Region.India),
  LinearA("Lina", "Linear A", null, Region.Greece),
  LinearB("Linb", "Linear B", null, Region.Greece),
  Fraser("Lisu", "Fraser", null, Region.China),
  Loma("Loma", "Loma", null, null),
  Lycian("Lyci", "Lycian", null, Region.Turkiye),
  Lydian("Lydi", "Lydian", null, Region.Turkiye),
  Mahajani("Mahj", "Mahajani", null, Region.India),
  Makasar("Maka", "Makasar", null, Region.Indonesia),
  Mandaean("Mand", "Mandaean", null, Region.Iran),
  Manichaean("Mani", "Manichaean", null, Region.China),
  Marchen("Marc", "Marchen", null, Region.China),
  MayanHieroglyphs("Maya", "Mayan hieroglyphs", null, null),
  Medefaidrin("Medf", "Medefaidrin", null, Region.Nigeria),
  Mende("Mend", "Mende", null, Region.SierraLeone),
  MeroiticCursive("Merc", "Meroitic Cursive", null, Region.Sudan),
  Meroitic("Mero", "Meroitic", null, Region.Sudan),
  Malayalam("Mlym", "Malayalam", null, Region.India),
  Modi("Modi", "Modi", null, Region.India),
  Mongolian("Mong", "Mongolian", null, Region.Mongolia),
  Moon("Moon", "Moon", null, null),
  Mro("Mroo", "Mro", null, Region.Bangladesh),
  MeiteiMayek("Mtei", "Meitei Mayek", null, Region.India),
  Multani("Mult", "Multani", null, Region.Pakistan),
  Myanmar("Mymr", "Myanmar", null, Region.MyanmarBurma),
  NagMundari("Nagm", "Nag Mundari", null, Region.India),
  Nandinagari("Nand", "Nandinagari", null, Region.India),
  OldNorthArabian("Narb", "Old North Arabian", null, Region.SaudiArabia),
  Nabataean("Nbat", "Nabataean", null, Region.Jordan),
  Newa("Newa", "Newa", null, Region.Nepal),
  NaxiGeba("Nkgb", "Naxi Geba", null, null),
  NKo("Nkoo", "N’Ko", null, Region.Guinea),
  Nushu("Nshu", "Nüshu", null, Region.China),
  Ogham("Ogam", "Ogham", null, Region.Ireland),
  OlChiki("Olck", "Ol Chiki", null, Region.India),
  OlOnal("Onao", "Ol Onal", null, Region.India),
  Orkhon("Orkh", "Orkhon", null, Region.Mongolia),
  Odia("Orya", "Odia", null, Region.India),
  Osage("Osge", "Osage", null, Region.UnitedStates),
  Osmanya("Osma", "Osmanya", null, Region.Somalia),
  OldUyghur("Ougr", "Old Uyghur", null, Region.China),
  Palmyrene("Palm", "Palmyrene", null, Region.Syria),
  PauCinHau("Pauc", "Pau Cin Hau", null, Region.MyanmarBurma),
  OldPermic("Perm", "Old Permic", null, Region.Russia),
  PhagsPa("Phag", "Phags-pa", null, Region.China),
  InscriptionalPahlavi("Phli", "Inscriptional Pahlavi", null, Region.Iran),
  PsalterPahlavi("Phlp", "Psalter Pahlavi", null, Region.China),
  BookPahlavi("Phlv", "Book Pahlavi", null, null),
  Phoenician("Phnx", "Phoenician", null, Region.Lebanon),
  PollardPhonetic("Plrd", "Pollard Phonetic", null, Region.China),
  InscriptionalParthian("Prti", "Inscriptional Parthian", null, Region.Iran),
  Zawgyi("Qaag", "Zawgyi", null, null),
  Rejang("Rjng", "Rejang", null, Region.Indonesia),
  Hanifi("Rohg", "Hanifi", null, Region.MyanmarBurma),
  Rongorongo("Roro", "Rongorongo", null, null),
  Runic("Runr", "Runic", null, Region.Sweden),
  Samaritan("Samr", "Samaritan", null, Region.Israel),
  Sarati("Sara", "Sarati", null, null),
  OldSouthArabian("Sarb", "Old South Arabian", null, Region.Yemen),
  Saurashtra("Saur", "Saurashtra", null, Region.India),
  SignWriting("Sgnw", "SignWriting", null, Region.UnitedStates),
  Shavian("Shaw", "Shavian", null, Region.UnitedKingdom),
  Sharada("Shrd", "Sharada", null, Region.India),
  Siddham("Sidd", "Siddham", null, Region.India),
  Khudawadi("Sind", "Khudawadi", null, Region.India),
  Sinhala("Sinh", "Sinhala", null, Region.SriLanka),
  Sogdian("Sogd", "Sogdian", null, Region.Uzbekistan),
  OldSogdian("Sogo", "Old Sogdian", null, Region.Uzbekistan),
  SoraSompeng("Sora", "Sora Sompeng", null, Region.India),
  Soyombo("Soyo", "Soyombo", null, Region.Mongolia),
  Sundanese("Sund", "Sundanese", null, Region.Indonesia),
  Sunuwar("Sunu", "Sunuwar", null, Region.Nepal),
  SylotiNagri("Sylo", "Syloti Nagri", null, Region.Bangladesh),
  Syriac("Syrc", "Syriac", null, Region.Syria),
  EstrangeloSyriac("Syre", "Estrangelo Syriac", null, null),
  WesternSyriac("Syrj", "Western Syriac", null, null),
  EasternSyriac("Syrn", "Eastern Syriac", null, null),
  Tagbanwa("Tagb", "Tagbanwa", null, Region.Philippines),
  Takri("Takr", "Takri", null, Region.India),
  TaiLe("Tale", "Tai Le", null, Region.China),
  NewTaiLue("Talu", "New Tai Lue", null, Region.China),
  Tamil("Taml", "Tamil", null, Region.India),
  Tangut("Tang", "Tangut", null, Region.China),
  TaiViet("Tavt", "Tai Viet", null, Region.Vietnam),
  Telugu("Telu", "Telugu", null, Region.India),
  Tengwar("Teng", "Tengwar", null, null),
  Tifinagh("Tfng", "Tifinagh", null, Region.Morocco),
  Tagalog("Tglg", "Tagalog", null, Region.Philippines),
  Thaana("Thaa", "Thaana", null, Region.Maldives),
  Thai("Thai", "Thai", null, Region.Thailand),
  Tibetan("Tibt", "Tibetan", null, Region.China),
  Tirhuta("Tirh", "Tirhuta", null, Region.India),
  Tangsa("Tnsa", "Tangsa", null, Region.India),
  Todhri("Todr", "Todhri", null, Region.Albania),
  Toto("Toto", "Toto", null, Region.India),
  TuluTigalari("Tutg", "Tulu-Tigalari", null, Region.India),
  Ugaritic("Ugar", "Ugaritic", null, Region.Syria),
  Vai("Vaii", "Vai", null, Region.Liberia),
  VisibleSpeech("Visp", "Visible Speech", null, null),
  Vithkuqi("Vith", "Vithkuqi", null, Region.Albania),
  VarangKshiti("Wara", "Varang Kshiti", null, Region.India),
  Wancho("Wcho", "Wancho", null, Region.India),
  Woleai("Wole", "Woleai", null, null),
  OldPersian("Xpeo", "Old Persian", null, Region.Iran),
  SumeroAkkadianCuneiform("Xsux", "Sumero-Akkadian Cuneiform", "S-A Cuneiform", Region.Iraq),
  Yezidi("Yezi", "Yezidi", null, Region.Georgia),
  Yi("Yiii", "Yi", null, Region.China),
  ZanabazarSquare("Zanb", "Zanabazar Square", null, Region.Mongolia),
  Inherited("Zinh", "Inherited", null, Region.UnknownRegion),
  MathematicalNotation("Zmth", "Mathematical Notation", null, null),
  Emoji("Zsye", "Emoji", null, null),
  Symbols("Zsym", "Symbols", null, null),
  Unwritten("Zxxx", "Unwritten", null, null),
  Common("Zyyy", "Common", null, Region.UnknownRegion),
  UnknownScript("Zzzz", "Unknown Script", null, Region.UnknownRegion),
}
