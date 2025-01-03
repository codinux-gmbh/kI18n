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
 * @param defaultLanguage Script's default language.
 * @param defaultRegion Script's default region.
 * @param originCountry The origin region of the script, if available.
 */
enum class Script(
  val code: String,
  val englishName: String,
  val variantName: String?,
  val defaultLanguage: Language?,
  val defaultRegion: Region?,
  val originCountry: Region?,
) {
  Adlam("Adlm", "Adlam", null, Language.Fula, Region.Guinea, Region.Guinea),
  Afaka("Afak", "Afaka", null, null, null, null),
  CaucasianAlbanian("Aghb", "Caucasian Albanian", null, null, Region.Azerbaijan, Region.Azerbaijan),
  Ahom("Ahom", "Ahom", null, null, Region.India, Region.India),
  Arabic("Arab", "Arabic", "Perso-Arabic", Language.Arabic, Region.Egypt, Region.SaudiArabia),
  Nastaliq("Aran", "Nastaliq", null, null, null, null),
  ImperialAramaic("Armi", "Imperial Aramaic", null, Language.Aramaic, Region.Iran, Region.Iran),
  Armenian("Armn", "Armenian", null, Language.Armenian, Region.Armenia, Region.Armenia),
  Avestan("Avst", "Avestan", null, Language.Avestan, Region.Iran, Region.Iran),
  Balinese("Bali", "Balinese", null, Language.Balinese, Region.Indonesia, Region.Indonesia),
  Bamum("Bamu", "Bamum", null, Language.Bamun, Region.Cameroon, Region.Cameroon),
  BassaVah("Bass", "Bassa Vah", null, null, Region.Liberia, Region.Liberia),
  Batak("Batk", "Batak", null, Language.BatakToba, Region.Indonesia, Region.Indonesia),
  Bangla("Beng", "Bangla", null, Language.Bangla, Region.Bangladesh, Region.Bangladesh),
  Bhaiksuki("Bhks", "Bhaiksuki", null, Language.Sanskrit, Region.India, Region.India),
  Blissymbols("Blis", "Blissymbols", null, null, null, null),
  Bopomofo("Bopo", "Bopomofo", null, Language.Chinese, Region.Taiwan, Region.China),
  Brahmi("Brah", "Brahmi", null, null, Region.India, Region.India),
  Braille("Brai", "Braille", null, Language.French, Region.France, Region.France),
  Buginese("Bugi", "Buginese", null, Language.Buginese, Region.Indonesia, Region.Indonesia),
  Buhid("Buhd", "Buhid", null, null, Region.Philippines, Region.Philippines),
  Chakma("Cakm", "Chakma", null, Language.Chakma, Region.Bangladesh, Region.Bangladesh),
  UnifiedCanadianAboriginalSyllabics("Cans", "Unified Canadian Aboriginal Syllabics", "UCAS", Language.Inuktitut, Region.Canada, Region.Canada),
  Carian("Cari", "Carian", null, null, Region.Turkiye, Region.Turkiye),
  Cham("Cham", "Cham", null, null, Region.Vietnam, Region.Vietnam),
  Cherokee("Cher", "Cherokee", null, Language.Cherokee, Region.UnitedStates, Region.UnitedStates),
  Chorasmian("Chrs", "Chorasmian", null, null, Region.Uzbekistan, Region.Uzbekistan),
  Cirth("Cirt", "Cirth", null, null, null, null),
  Coptic("Copt", "Coptic", null, Language.Coptic, Region.Egypt, Region.Egypt),
  CyproMinoan("Cpmn", "Cypro-Minoan", null, Language.UnknownLanguage, Region.Cyprus, Region.Cyprus),
  Cypriot("Cprt", "Cypriot", null, Language.AncientGreek, Region.Cyprus, Region.Cyprus),
  Cyrillic("Cyrl", "Cyrillic", null, Language.Russian, Region.Russia, Region.Bulgaria),
  OldChurchSlavonicCyrillic("Cyrs", "Old Church Slavonic Cyrillic", null, null, null, null),
  Devanagari("Deva", "Devanagari", null, Language.Hindi, Region.India, Region.India),
  DivesAkuru("Diak", "Dives Akuru", null, Language.Divehi, Region.Maldives, Region.Maldives),
  Dogra("Dogr", "Dogra", null, Language.Dogri, Region.India, Region.India),
  Deseret("Dsrt", "Deseret", null, null, null, Region.UnitedStates),
  DuployanShorthand("Dupl", "Duployan shorthand", null, Language.French, Region.France, Region.France),
  EgyptianDemotic("Egyd", "Egyptian demotic", null, null, null, null),
  EgyptianHieratic("Egyh", "Egyptian hieratic", null, null, null, null),
  EgyptianHieroglyphs("Egyp", "Egyptian hieroglyphs", null, Language.AncientEgyptian, Region.Egypt, Region.Egypt),
  Elbasan("Elba", "Elbasan", null, Language.Albanian, Region.Albania, Region.Albania),
  Elymaic("Elym", "Elymaic", null, Language.Aramaic, Region.Iran, Region.Iran),
  Ethiopic("Ethi", "Ethiopic", null, Language.Amharic, Region.Ethiopia, Region.Ethiopia),
  Garay("Gara", "Garay", null, Language.Wolof, Region.Senegal, Region.Senegal),
  GeorgianKhutsuri("Geok", "Georgian Khutsuri", null, null, null, null),
  Georgian("Geor", "Georgian", null, Language.Georgian, Region.Georgia, Region.Georgia),
  Glagolitic("Glag", "Glagolitic", null, Language.ChurchSlavic, Region.Bulgaria, Region.Bulgaria),
  GunjalaGondi("Gong", "Gunjala Gondi", null, null, Region.India, Region.India),
  MasaramGondi("Gonm", "Masaram Gondi", null, null, Region.India, Region.India),
  Gothic("Goth", "Gothic", null, Language.Gothic, Region.Ukraine, Region.Ukraine),
  Grantha("Gran", "Grantha", null, Language.Sanskrit, Region.India, Region.India),
  Greek("Grek", "Greek", null, Language.Greek, Region.Greece, Region.Greece),
  Gujarati("Gujr", "Gujarati", null, Language.Gujarati, Region.India, Region.India),
  GurungKhema("Gukh", "Gurung Khema", null, null, Region.Nepal, Region.Nepal),
  Gurmukhi("Guru", "Gurmukhi", null, Language.Punjabi, Region.India, Region.India),
  HanWithBopomofo("Hanb", "Han with Bopomofo", null, Language.Chinese, Region.Taiwan, Region.China),
  Hangul("Hang", "Hangul", null, Language.Korean, Region.SouthKorea, Region.SouthKorea),
  Han("Hani", "Han", null, Language.Chinese, Region.China, Region.China),
  Hanunoo("Hano", "Hanunoo", null, null, Region.Philippines, Region.Philippines),
  Simplified("Hans", "Simplified", null, Language.Chinese, Region.China, Region.China),
  Traditional("Hant", "Traditional", null, Language.Chinese, Region.Taiwan, Region.China),
  Hatran("Hatr", "Hatran", null, Language.Aramaic, Region.Iraq, Region.Iraq),
  Hebrew("Hebr", "Hebrew", null, Language.Hebrew, Region.Israel, Region.Israel),
  Hiragana("Hira", "Hiragana", null, Language.Japanese, Region.Japan, Region.Japan),
  AnatolianHieroglyphs("Hluw", "Anatolian Hieroglyphs", null, null, Region.Turkiye, Region.Turkiye),
  PahawhHmong("Hmng", "Pahawh Hmong", null, Language.HmongNjua, Region.Laos, Region.Laos),
  NyiakengPuachueHmong("Hmnp", "Nyiakeng Puachue Hmong", null, Language.HmongNjua, Region.UnitedStates, Region.UnitedStates),
  JapaneseSyllabaries("Hrkt", "Japanese syllabaries", null, null, null, null),
  OldHungarian("Hung", "Old Hungarian", null, Language.Hungarian, Region.Hungary, Region.Hungary),
  Indus("Inds", "Indus", null, null, null, null),
  OldItalic("Ital", "Old Italic", null, null, Region.Italy, Region.Italy),
  Jamo("Jamo", "Jamo", null, Language.Korean, Region.SouthKorea, Region.SouthKorea),
  Javanese("Java", "Javanese", null, Language.Javanese, Region.Indonesia, Region.Indonesia),
  Japanese("Jpan", "Japanese", null, Language.Japanese, Region.Japan, Region.Japan),
  Jurchen("Jurc", "Jurchen", null, null, null, null),
  KayahLi("Kali", "Kayah Li", null, null, Region.MyanmarBurma, Region.MyanmarBurma),
  Katakana("Kana", "Katakana", null, Language.Japanese, Region.Japan, Region.Japan),
  Kawi("Kawi", "Kawi", null, Language.Kawi, Region.Indonesia, Region.Indonesia),
  Kharoshthi("Khar", "Kharoshthi", null, null, Region.Pakistan, Region.Pakistan),
  Khmer("Khmr", "Khmer", null, Language.Khmer, Region.Cambodia, Region.Cambodia),
  Khojki("Khoj", "Khojki", null, Language.Sindhi, Region.India, Region.India),
  KhitanSmallScript("Kits", "Khitan small script", null, null, Region.China, Region.China),
  Kannada("Knda", "Kannada", null, Language.Kannada, Region.India, Region.India),
  Korean("Kore", "Korean", null, Language.Korean, Region.SouthKorea, Region.SouthKorea),
  Kpelle("Kpel", "Kpelle", null, null, null, null),
  KiratRai("Krai", "Kirat Rai", null, null, Region.India, Region.India),
  Kaithi("Kthi", "Kaithi", null, Language.Bhojpuri, Region.India, Region.India),
  Lanna("Lana", "Lanna", null, null, Region.Thailand, Region.Thailand),
  Lao("Laoo", "Lao", null, Language.Lao, Region.Laos, Region.Laos),
  FrakturLatin("Latf", "Fraktur Latin", null, null, null, null),
  GaelicLatin("Latg", "Gaelic Latin", null, null, null, null),
  Latin("Latn", "Latin", null, null, null, Region.Italy),
  Lepcha("Lepc", "Lepcha", null, null, Region.India, Region.India),
  Limbu("Limb", "Limbu", null, null, Region.India, Region.India),
  LinearA("Lina", "Linear A", null, null, Region.Greece, Region.Greece),
  LinearB("Linb", "Linear B", null, Language.AncientGreek, Region.Greece, Region.Greece),
  Fraser("Lisu", "Fraser", null, null, Region.China, Region.China),
  Loma("Loma", "Loma", null, null, null, null),
  Lycian("Lyci", "Lycian", null, null, Region.Turkiye, Region.Turkiye),
  Lydian("Lydi", "Lydian", null, null, Region.Turkiye, Region.Turkiye),
  Mahajani("Mahj", "Mahajani", null, Language.Hindi, Region.India, Region.India),
  Makasar("Maka", "Makasar", null, Language.Makasar, Region.Indonesia, Region.Indonesia),
  Mandaean("Mand", "Mandaean", null, null, Region.Iran, Region.Iran),
  Manichaean("Mani", "Manichaean", null, null, Region.China, Region.China),
  Marchen("Marc", "Marchen", null, Language.Tibetan, Region.China, Region.China),
  MayanHieroglyphs("Maya", "Mayan hieroglyphs", null, null, null, null),
  Medefaidrin("Medf", "Medefaidrin", null, null, Region.Nigeria, Region.Nigeria),
  Mende("Mend", "Mende", null, Language.Mende, Region.SierraLeone, Region.SierraLeone),
  MeroiticCursive("Merc", "Meroitic Cursive", null, null, Region.Sudan, Region.Sudan),
  Meroitic("Mero", "Meroitic", null, null, Region.Sudan, Region.Sudan),
  Malayalam("Mlym", "Malayalam", null, Language.Malayalam, Region.India, Region.India),
  Modi("Modi", "Modi", null, Language.Marathi, Region.India, Region.India),
  Mongolian("Mong", "Mongolian", null, Language.Mongolian, Region.China, Region.Mongolia),
  Moon("Moon", "Moon", null, null, null, null),
  Mro("Mroo", "Mro", null, null, Region.Bangladesh, Region.Bangladesh),
  MeiteiMayek("Mtei", "Meitei Mayek", null, Language.Manipuri, Region.India, Region.India),
  Multani("Mult", "Multani", null, Language.Saraiki, Region.Pakistan, Region.Pakistan),
  Myanmar("Mymr", "Myanmar", null, Language.Burmese, Region.MyanmarBurma, Region.MyanmarBurma),
  NagMundari("Nagm", "Nag Mundari", null, null, Region.India, Region.India),
  Nandinagari("Nand", "Nandinagari", null, Language.Sanskrit, Region.India, Region.India),
  OldNorthArabian("Narb", "Old North Arabian", null, null, Region.SaudiArabia, Region.SaudiArabia),
  Nabataean("Nbat", "Nabataean", null, Language.Aramaic, Region.Jordan, Region.Jordan),
  Newa("Newa", "Newa", null, Language.Newari, Region.Nepal, Region.Nepal),
  NaxiGeba("Nkgb", "Naxi Geba", null, null, null, null),
  NKo("Nkoo", "N’Ko", null, Language.Mandingo, Region.Guinea, Region.Guinea),
  Nushu("Nshu", "Nüshu", null, null, Region.China, Region.China),
  Ogham("Ogam", "Ogham", null, Language.OldIrish, Region.Ireland, Region.Ireland),
  OlChiki("Olck", "Ol Chiki", null, Language.Santali, Region.India, Region.India),
  OlOnal("Onao", "Ol Onal", null, null, Region.India, Region.India),
  Orkhon("Orkh", "Orkhon", null, null, Region.Mongolia, Region.Mongolia),
  Odia("Orya", "Odia", null, Language.Odia, Region.India, Region.India),
  Osage("Osge", "Osage", null, Language.Osage, Region.UnitedStates, Region.UnitedStates),
  Osmanya("Osma", "Osmanya", null, Language.Somali, Region.Somalia, Region.Somalia),
  OldUyghur("Ougr", "Old Uyghur", null, null, Region.China, Region.China),
  Palmyrene("Palm", "Palmyrene", null, Language.Aramaic, Region.Syria, Region.Syria),
  PauCinHau("Pauc", "Pau Cin Hau", null, null, Region.MyanmarBurma, Region.MyanmarBurma),
  OldPermic("Perm", "Old Permic", null, Language.Komi, Region.Russia, Region.Russia),
  PhagsPa("Phag", "Phags-pa", null, Language.LiteraryChinese, Region.China, Region.China),
  InscriptionalPahlavi("Phli", "Inscriptional Pahlavi", null, Language.Pahlavi, Region.Iran, Region.Iran),
  PsalterPahlavi("Phlp", "Psalter Pahlavi", null, Language.Pahlavi, Region.China, Region.China),
  BookPahlavi("Phlv", "Book Pahlavi", null, null, null, null),
  Phoenician("Phnx", "Phoenician", null, Language.Phoenician, Region.Lebanon, Region.Lebanon),
  PollardPhonetic("Plrd", "Pollard Phonetic", null, null, Region.China, Region.China),
  InscriptionalParthian("Prti", "Inscriptional Parthian", null, null, Region.Iran, Region.Iran),
  Zawgyi("Qaag", "Zawgyi", null, null, null, null),
  Rejang("Rjng", "Rejang", null, null, Region.Indonesia, Region.Indonesia),
  Hanifi("Rohg", "Hanifi", null, Language.Rohingya, Region.MyanmarBurma, Region.MyanmarBurma),
  Rongorongo("Roro", "Rongorongo", null, null, null, null),
  Runic("Runr", "Runic", null, Language.OldNorse, Region.Sweden, Region.Sweden),
  Samaritan("Samr", "Samaritan", null, null, Region.Israel, Region.Israel),
  Sarati("Sara", "Sarati", null, null, null, null),
  OldSouthArabian("Sarb", "Old South Arabian", null, null, Region.Yemen, Region.Yemen),
  Saurashtra("Saur", "Saurashtra", null, Language.Saurashtra, Region.India, Region.India),
  SignWriting("Sgnw", "SignWriting", null, Language.AmericanSignLanguage, Region.UnitedStates, Region.UnitedStates),
  Shavian("Shaw", "Shavian", null, Language.English, Region.UnitedKingdom, Region.UnitedKingdom),
  Sharada("Shrd", "Sharada", null, Language.Sanskrit, Region.India, Region.India),
  Siddham("Sidd", "Siddham", null, Language.Sanskrit, Region.India, Region.India),
  Khudawadi("Sind", "Khudawadi", null, Language.Sindhi, Region.India, Region.India),
  Sinhala("Sinh", "Sinhala", null, Language.Sinhala, Region.SriLanka, Region.SriLanka),
  Sogdian("Sogd", "Sogdian", null, Language.Sogdien, Region.Uzbekistan, Region.Uzbekistan),
  OldSogdian("Sogo", "Old Sogdian", null, Language.Sogdien, Region.Uzbekistan, Region.Uzbekistan),
  SoraSompeng("Sora", "Sora Sompeng", null, null, Region.India, Region.India),
  Soyombo("Soyo", "Soyombo", null, null, Region.Mongolia, Region.Mongolia),
  Sundanese("Sund", "Sundanese", null, Language.Sundanese, Region.Indonesia, Region.Indonesia),
  Sunuwar("Sunu", "Sunuwar", null, null, Region.Nepal, Region.Nepal),
  SylotiNagri("Sylo", "Syloti Nagri", null, null, Region.Bangladesh, Region.Bangladesh),
  Syriac("Syrc", "Syriac", null, Language.Syriac, Region.Iraq, Region.Syria),
  EstrangeloSyriac("Syre", "Estrangelo Syriac", null, null, null, null),
  WesternSyriac("Syrj", "Western Syriac", null, null, null, null),
  EasternSyriac("Syrn", "Eastern Syriac", null, null, null, null),
  Tagbanwa("Tagb", "Tagbanwa", null, null, Region.Philippines, Region.Philippines),
  Takri("Takr", "Takri", null, Language.Dogri, Region.India, Region.India),
  TaiLe("Tale", "Tai Le", null, null, Region.China, Region.China),
  NewTaiLue("Talu", "New Tai Lue", null, null, Region.China, Region.China),
  Tamil("Taml", "Tamil", null, Language.Tamil, Region.India, Region.India),
  Tangut("Tang", "Tangut", null, null, Region.China, Region.China),
  TaiViet("Tavt", "Tai Viet", null, Language.TaiDam, Region.Vietnam, Region.Vietnam),
  Telugu("Telu", "Telugu", null, Language.Telugu, Region.India, Region.India),
  Tengwar("Teng", "Tengwar", null, null, null, null),
  Tifinagh("Tfng", "Tifinagh", null, Language.StandardMoroccanTamazight, Region.Morocco, Region.Morocco),
  Tagalog("Tglg", "Tagalog", null, Language.Filipino, Region.Philippines, Region.Philippines),
  Thaana("Thaa", "Thaana", null, Language.Divehi, Region.Maldives, Region.Maldives),
  Thai("Thai", "Thai", null, Language.Thai, Region.Thailand, Region.Thailand),
  Tibetan("Tibt", "Tibetan", null, Language.Tibetan, Region.China, Region.China),
  Tirhuta("Tirh", "Tirhuta", null, Language.Maithili, Region.India, Region.India),
  Tangsa("Tnsa", "Tangsa", null, null, Region.India, Region.India),
  Todhri("Todr", "Todhri", null, Language.Albanian, Region.Albania, Region.Albania),
  Toto("Toto", "Toto", null, null, Region.India, Region.India),
  TuluTigalari("Tutg", "Tulu-Tigalari", null, Language.Sanskrit, Region.India, Region.India),
  Ugaritic("Ugar", "Ugaritic", null, Language.Ugaritic, Region.Syria, Region.Syria),
  Vai("Vaii", "Vai", null, Language.Vai, Region.Liberia, Region.Liberia),
  VisibleSpeech("Visp", "Visible Speech", null, null, null, null),
  Vithkuqi("Vith", "Vithkuqi", null, Language.Albanian, Region.Albania, Region.Albania),
  VarangKshiti("Wara", "Varang Kshiti", null, null, Region.India, Region.India),
  Wancho("Wcho", "Wancho", null, null, Region.India, Region.India),
  Woleai("Wole", "Woleai", null, null, null, null),
  OldPersian("Xpeo", "Old Persian", null, Language.OldPersian, Region.Iran, Region.Iran),
  SumeroAkkadianCuneiform("Xsux", "Sumero-Akkadian Cuneiform", "S-A Cuneiform", Language.Akkadian, Region.Iraq, Region.Iraq),
  Yezidi("Yezi", "Yezidi", null, Language.Kurdish, Region.Georgia, Region.Georgia),
  Yi("Yiii", "Yi", null, Language.SichuanYi, Region.China, Region.China),
  ZanabazarSquare("Zanb", "Zanabazar Square", null, null, Region.Mongolia, Region.Mongolia),
  Inherited("Zinh", "Inherited", null, null, null, Region.UnknownRegion),
  MathematicalNotation("Zmth", "Mathematical Notation", null, null, null, null),
  Emoji("Zsye", "Emoji", null, null, null, null),
  Symbols("Zsym", "Symbols", null, null, null, null),
  Unwritten("Zxxx", "Unwritten", null, null, null, null),
  Common("Zyyy", "Common", null, null, null, Region.UnknownRegion),
  UnknownScript("Zzzz", "Unknown Script", null, null, null, Region.UnknownRegion),
}
