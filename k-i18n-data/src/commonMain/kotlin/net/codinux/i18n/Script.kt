package net.codinux.i18n

import kotlin.String

/**
 * @param code Four-letter ISO 15924 code in title case.
 *
 *  The codes 900–999 are special codes, aliases or for private use.
 *
 *  Special codes:
 *  - Qaaa–Qabx (900–949): 50 Codes reserved for private use (for example, Qaag is used to mark Burmese text encoded for the Zawgyi font)
 *  - Zsye 993: Emoji
 *  - Zinh 994: Code for inherited script
 *  - Zmth 995: Mathematical notation
 *  - Zsym 996: Symbols
 *  - Zxxx 997: Code for unwritten documents
 *  - Zyyy 998: Code for undetermined script
 *  - Zzzz 999: Code for uncoded script
 *
 *  Two four-letter codes are reserved at the request of the Common Locale Data Repository (CLDR) project:
 *  - Root: Reserved for the language-neutral base of the CLDR locale tree
 *  - True: Reserved for the Boolean value "true")
 * @param englishName English name of the script.
 * @param variantName Optional a variant of the English name of the script (if available).
 */
enum class Script(
  val code: String,
  val englishName: String,
  val variantName: String?,
) {
  Adlam("Adlm", "Adlam", null),
  Afaka("Afak", "Afaka", null),
  CaucasianAlbanian("Aghb", "Caucasian Albanian", null),
  Ahom("Ahom", "Ahom", null),
  Arabic("Arab", "Arabic", "Perso-Arabic"),
  Nastaliq("Aran", "Nastaliq", null),
  ImperialAramaic("Armi", "Imperial Aramaic", null),
  Armenian("Armn", "Armenian", null),
  Avestan("Avst", "Avestan", null),
  Balinese("Bali", "Balinese", null),
  Bamum("Bamu", "Bamum", null),
  BassaVah("Bass", "Bassa Vah", null),
  Batak("Batk", "Batak", null),
  Bangla("Beng", "Bangla", null),
  Bhaiksuki("Bhks", "Bhaiksuki", null),
  Blissymbols("Blis", "Blissymbols", null),
  Bopomofo("Bopo", "Bopomofo", null),
  Brahmi("Brah", "Brahmi", null),
  Braille("Brai", "Braille", null),
  Buginese("Bugi", "Buginese", null),
  Buhid("Buhd", "Buhid", null),
  Chakma("Cakm", "Chakma", null),
  UnifiedCanadianAboriginalSyllabics("Cans", "Unified Canadian Aboriginal Syllabics", "UCAS"),
  Carian("Cari", "Carian", null),
  Cham("Cham", "Cham", null),
  Cherokee("Cher", "Cherokee", null),
  Chorasmian("Chrs", "Chorasmian", null),
  Cirth("Cirt", "Cirth", null),
  Coptic("Copt", "Coptic", null),
  CyproMinoan("Cpmn", "Cypro-Minoan", null),
  Cypriot("Cprt", "Cypriot", null),
  Cyrillic("Cyrl", "Cyrillic", null),
  OldChurchSlavonicCyrillic("Cyrs", "Old Church Slavonic Cyrillic", null),
  Devanagari("Deva", "Devanagari", null),
  DivesAkuru("Diak", "Dives Akuru", null),
  Dogra("Dogr", "Dogra", null),
  Deseret("Dsrt", "Deseret", null),
  Duployanshorthand("Dupl", "Duployan shorthand", null),
  Egyptiandemotic("Egyd", "Egyptian demotic", null),
  Egyptianhieratic("Egyh", "Egyptian hieratic", null),
  Egyptianhieroglyphs("Egyp", "Egyptian hieroglyphs", null),
  Elbasan("Elba", "Elbasan", null),
  Elymaic("Elym", "Elymaic", null),
  Ethiopic("Ethi", "Ethiopic", null),
  Garay("Gara", "Garay", null),
  GeorgianKhutsuri("Geok", "Georgian Khutsuri", null),
  Georgian("Geor", "Georgian", null),
  Glagolitic("Glag", "Glagolitic", null),
  GunjalaGondi("Gong", "Gunjala Gondi", null),
  MasaramGondi("Gonm", "Masaram Gondi", null),
  Gothic("Goth", "Gothic", null),
  Grantha("Gran", "Grantha", null),
  Greek("Grek", "Greek", null),
  Gujarati("Gujr", "Gujarati", null),
  GurungKhema("Gukh", "Gurung Khema", null),
  Gurmukhi("Guru", "Gurmukhi", null),
  HanwithBopomofo("Hanb", "Han with Bopomofo", null),
  Hangul("Hang", "Hangul", null),
  Han("Hani", "Han", null),
  Hanunoo("Hano", "Hanunoo", null),
  Simplified("Hans", "Simplified", null),
  Traditional("Hant", "Traditional", null),
  Hatran("Hatr", "Hatran", null),
  Hebrew("Hebr", "Hebrew", null),
  Hiragana("Hira", "Hiragana", null),
  AnatolianHieroglyphs("Hluw", "Anatolian Hieroglyphs", null),
  PahawhHmong("Hmng", "Pahawh Hmong", null),
  NyiakengPuachueHmong("Hmnp", "Nyiakeng Puachue Hmong", null),
  Japanesesyllabaries("Hrkt", "Japanese syllabaries", null),
  OldHungarian("Hung", "Old Hungarian", null),
  Indus("Inds", "Indus", null),
  OldItalic("Ital", "Old Italic", null),
  Jamo("Jamo", "Jamo", null),
  Javanese("Java", "Javanese", null),
  Japanese("Jpan", "Japanese", null),
  Jurchen("Jurc", "Jurchen", null),
  KayahLi("Kali", "Kayah Li", null),
  Katakana("Kana", "Katakana", null),
  Kawi("Kawi", "Kawi", null),
  Kharoshthi("Khar", "Kharoshthi", null),
  Khmer("Khmr", "Khmer", null),
  Khojki("Khoj", "Khojki", null),
  Khitansmallscript("Kits", "Khitan small script", null),
  Kannada("Knda", "Kannada", null),
  Korean("Kore", "Korean", null),
  Kpelle("Kpel", "Kpelle", null),
  KiratRai("Krai", "Kirat Rai", null),
  Kaithi("Kthi", "Kaithi", null),
  Lanna("Lana", "Lanna", null),
  Lao("Laoo", "Lao", null),
  FrakturLatin("Latf", "Fraktur Latin", null),
  GaelicLatin("Latg", "Gaelic Latin", null),
  Latin("Latn", "Latin", null),
  Lepcha("Lepc", "Lepcha", null),
  Limbu("Limb", "Limbu", null),
  LinearA("Lina", "Linear A", null),
  LinearB("Linb", "Linear B", null),
  Fraser("Lisu", "Fraser", null),
  Loma("Loma", "Loma", null),
  Lycian("Lyci", "Lycian", null),
  Lydian("Lydi", "Lydian", null),
  Mahajani("Mahj", "Mahajani", null),
  Makasar("Maka", "Makasar", null),
  Mandaean("Mand", "Mandaean", null),
  Manichaean("Mani", "Manichaean", null),
  Marchen("Marc", "Marchen", null),
  Mayanhieroglyphs("Maya", "Mayan hieroglyphs", null),
  Medefaidrin("Medf", "Medefaidrin", null),
  Mende("Mend", "Mende", null),
  MeroiticCursive("Merc", "Meroitic Cursive", null),
  Meroitic("Mero", "Meroitic", null),
  Malayalam("Mlym", "Malayalam", null),
  Modi("Modi", "Modi", null),
  Mongolian("Mong", "Mongolian", null),
  Moon("Moon", "Moon", null),
  Mro("Mroo", "Mro", null),
  MeiteiMayek("Mtei", "Meitei Mayek", null),
  Multani("Mult", "Multani", null),
  Myanmar("Mymr", "Myanmar", null),
  NagMundari("Nagm", "Nag Mundari", null),
  Nandinagari("Nand", "Nandinagari", null),
  OldNorthArabian("Narb", "Old North Arabian", null),
  Nabataean("Nbat", "Nabataean", null),
  Newa("Newa", "Newa", null),
  NaxiGeba("Nkgb", "Naxi Geba", null),
  NKo("Nkoo", "N’Ko", null),
  Nushu("Nshu", "Nüshu", null),
  Ogham("Ogam", "Ogham", null),
  OlChiki("Olck", "Ol Chiki", null),
  OlOnal("Onao", "Ol Onal", null),
  Orkhon("Orkh", "Orkhon", null),
  Odia("Orya", "Odia", null),
  Osage("Osge", "Osage", null),
  Osmanya("Osma", "Osmanya", null),
  OldUyghur("Ougr", "Old Uyghur", null),
  Palmyrene("Palm", "Palmyrene", null),
  PauCinHau("Pauc", "Pau Cin Hau", null),
  OldPermic("Perm", "Old Permic", null),
  Phagspa("Phag", "Phags-pa", null),
  InscriptionalPahlavi("Phli", "Inscriptional Pahlavi", null),
  PsalterPahlavi("Phlp", "Psalter Pahlavi", null),
  BookPahlavi("Phlv", "Book Pahlavi", null),
  Phoenician("Phnx", "Phoenician", null),
  PollardPhonetic("Plrd", "Pollard Phonetic", null),
  InscriptionalParthian("Prti", "Inscriptional Parthian", null),
  Zawgyi("Qaag", "Zawgyi", null),
  Rejang("Rjng", "Rejang", null),
  Hanifi("Rohg", "Hanifi", null),
  Rongorongo("Roro", "Rongorongo", null),
  Runic("Runr", "Runic", null),
  Samaritan("Samr", "Samaritan", null),
  Sarati("Sara", "Sarati", null),
  OldSouthArabian("Sarb", "Old South Arabian", null),
  Saurashtra("Saur", "Saurashtra", null),
  SignWriting("Sgnw", "SignWriting", null),
  Shavian("Shaw", "Shavian", null),
  Sharada("Shrd", "Sharada", null),
  Siddham("Sidd", "Siddham", null),
  Khudawadi("Sind", "Khudawadi", null),
  Sinhala("Sinh", "Sinhala", null),
  Sogdian("Sogd", "Sogdian", null),
  OldSogdian("Sogo", "Old Sogdian", null),
  SoraSompeng("Sora", "Sora Sompeng", null),
  Soyombo("Soyo", "Soyombo", null),
  Sundanese("Sund", "Sundanese", null),
  Sunuwar("Sunu", "Sunuwar", null),
  SylotiNagri("Sylo", "Syloti Nagri", null),
  Syriac("Syrc", "Syriac", null),
  EstrangeloSyriac("Syre", "Estrangelo Syriac", null),
  WesternSyriac("Syrj", "Western Syriac", null),
  EasternSyriac("Syrn", "Eastern Syriac", null),
  Tagbanwa("Tagb", "Tagbanwa", null),
  Takri("Takr", "Takri", null),
  TaiLe("Tale", "Tai Le", null),
  NewTaiLue("Talu", "New Tai Lue", null),
  Tamil("Taml", "Tamil", null),
  Tangut("Tang", "Tangut", null),
  TaiViet("Tavt", "Tai Viet", null),
  Telugu("Telu", "Telugu", null),
  Tengwar("Teng", "Tengwar", null),
  Tifinagh("Tfng", "Tifinagh", null),
  Tagalog("Tglg", "Tagalog", null),
  Thaana("Thaa", "Thaana", null),
  Thai("Thai", "Thai", null),
  Tibetan("Tibt", "Tibetan", null),
  Tirhuta("Tirh", "Tirhuta", null),
  Tangsa("Tnsa", "Tangsa", null),
  Todhri("Todr", "Todhri", null),
  Toto("Toto", "Toto", null),
  TuluTigalari("Tutg", "Tulu-Tigalari", null),
  Ugaritic("Ugar", "Ugaritic", null),
  Vai("Vaii", "Vai", null),
  VisibleSpeech("Visp", "Visible Speech", null),
  Vithkuqi("Vith", "Vithkuqi", null),
  VarangKshiti("Wara", "Varang Kshiti", null),
  Wancho("Wcho", "Wancho", null),
  Woleai("Wole", "Woleai", null),
  OldPersian("Xpeo", "Old Persian", null),
  SumeroAkkadianCuneiform("Xsux", "Sumero-Akkadian Cuneiform", "S-A Cuneiform"),
  Yezidi("Yezi", "Yezidi", null),
  Yi("Yiii", "Yi", null),
  ZanabazarSquare("Zanb", "Zanabazar Square", null),
  Inherited("Zinh", "Inherited", null),
  MathematicalNotation("Zmth", "Mathematical Notation", null),
  Emoji("Zsye", "Emoji", null),
  Symbols("Zsym", "Symbols", null),
  Unwritten("Zxxx", "Unwritten", null),
  Common("Zyyy", "Common", null),
  UnknownScript("Zzzz", "Unknown Script", null),
}
