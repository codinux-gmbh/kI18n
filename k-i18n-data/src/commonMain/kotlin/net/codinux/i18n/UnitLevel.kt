package net.codinux.i18n

enum class UnitLevel {

    /**
     * SI normative units, standard and commonly used multiples.
     */
    Normative, // Level 1

    /**
     * SI normative equivalent units (UK, US, etc.) and commonly used multiples
     */
    NormativeEquivalent, // Level 2

    /**
     * 9 categories of informative units (units of count and other
     * miscellaneous units), invariably with no comprehensive conversion factor to SI.
     * These units are provided for information and to facilitate the assignment and usage of
     * a common code value to represent such units.
     *
     * 3.1 Qualified base units from levels 1 and 2
     * 3.2 Sales units
     * 3.3 Packing units
     * 3.4 Shipping and transportation units
     * 3.5 Industry specific units (various)
     * 3.6 Information technology units
     * 3.7 Integers/Numbers/Ratios
     * 3.8 Multiples/Fractions/Decimals
     * 3.9 Miscellaneous
     */
    Informative

}