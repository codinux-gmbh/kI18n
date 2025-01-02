package net.codinux.i18n.units

import kotlin.String
import kotlin.collections.List

enum class UnitType(
  val type: String,
  val units: List<String>,
) {
  Acceleration("acceleration", listOf("g-force", "meter-per-square-second")),
  Angle("angle", listOf("arc-minute", "arc-second", "degree", "radian", "revolution")),
  Area("area", listOf("acre", "bu-jp", "cho", "dunam", "hectare", "se-jp", "square-meter")),
  CatalyticActivity("catalytic-activity", listOf("item-per-second", "katal")),
  Concentration("concentration", listOf("item-per-cubic-meter")),
  ConcentrationMass("concentration-mass", listOf("item-per-kilogram", "ofglucose")),
  Consumption("consumption", listOf("cubic-meter-per-meter")),
  CurrentDensity("current-density", listOf("ampere-per-square-meter")),
  Digital("digital", listOf("bit", "byte")),
  Duration("duration", listOf("day", "day-person", "fortnight", "hour", "minute", "second", "week", "week-person")),
  ElectricCapacitance("electric-capacitance", listOf("farad", "pow4-second-square-ampere-per-kilogram-square-meter")),
  ElectricCharge("electric-charge", listOf("coulomb", "second-ampere")),
  ElectricConductance("electric-conductance", listOf("cubic-second-square-ampere-per-kilogram-square-meter", "siemens")),
  ElectricCurrent("electric-current", listOf("ampere")),
  ElectricInductance("electric-inductance", listOf("henry", "kilogram-square-meter-per-square-second-square-ampere")),
  ElectricResistance("electric-resistance", listOf("kilogram-square-meter-per-cubic-second-square-ampere", "ohm")),
  Energy("energy", listOf("british-thermal-unit", "british-thermal-unit-it", "calorie", "calorie-it", "electronvolt", "foodcalorie", "joule", "kilogram-square-meter-per-square-second", "therm-us")),
  Force("force", listOf("kilogram-force", "kilogram-meter-per-square-second", "newton", "pound-force")),
  Frequency("frequency", listOf("hertz", "revolution-per-second")),
  Graphics("graphics", listOf("dot", "pixel")),
  Illuminance("illuminance", listOf("candela-per-square-meter", "lux")),
  IonizingRadiation("ionizing-radiation", listOf("gray", "sievert", "square-meter-per-square-second")),
  Length("length", listOf("100-kilometer", "astronomical-unit", "chain", "earth-radius", "fathom", "foot", "furlong", "inch", "jo-jp", "ken", "light-year", "meter", "mile", "mile-scandinavian", "nautical-mile", "parsec", "point", "ri-jp", "rin", "rod", "shaku-cloth", "shaku-length", "solar-radius", "sun", "yard")),
  LuminousFlux("luminous-flux", listOf("candela-square-meter-per-square-meter", "lumen")),
  LuminousIntensity("luminous-intensity", listOf("candela")),
  MagneticFieldStrength("magnetic-field-strength", listOf("ampere-per-meter")),
  MagneticFlux("magnetic-flux", listOf("kilogram-square-meter-per-square-second-ampere", "weber")),
  MagneticInduction("magnetic-induction", listOf("kilogram-per-square-second-ampere", "tesla")),
  Mass("mass", listOf("carat", "dalton", "earth-mass", "fun", "grain", "gram", "kilogram", "ounce", "ounce-troy", "pound", "slug", "solar-mass", "stone", "ton", "tonne")),
  MassDensity("mass-density", listOf("kilogram-per-cubic-meter")),
  MassFraction("mass-fraction", listOf("kilogram-per-kilogram")),
  NightDuration("night-duration", listOf("night")),
  Portion("portion", listOf("karat", "percent", "permille", "permillion", "permyriad", "portion")),
  Power("power", listOf("horsepower", "kilogram-square-meter-per-cubic-second", "solar-luminosity", "watt")),
  Pressure("pressure", listOf("atmosphere", "bar", "gasoline-energy-density", "kilogram-per-meter-square-second", "pascal")),
  PressurePerLength("pressure-per-length", listOf("kilogram-per-square-meter-square-second", "ofhg")),
  Radioactivity("radioactivity", listOf("becquerel", "per-second")),
  Resolution("resolution", listOf("pixel-per-meter")),
  SolidAngle("solid-angle", listOf("square-revolution", "steradian")),
  SpecificVolume("specific-volume", listOf("cubic-meter-per-kilogram")),
  Speed("speed", listOf("beaufort", "knot", "light-speed", "meter-per-second")),
  SubstanceAmount("substance-amount", listOf("item", "mole")),
  Temperature("temperature", listOf("celsius", "fahrenheit", "kelvin", "rankine")),
  Typewidth("typewidth", listOf("em")),
  Voltage("voltage", listOf("kilogram-square-meter-per-cubic-second-ampere", "volt")),
  Volume("volume", listOf("barrel", "bushel", "cubic-meter", "cup", "cup-jp", "cup-metric", "dessert-spoon", "dessert-spoon-imperial", "dram", "drop", "fluid-ounce", "fluid-ounce-imperial", "gallon", "gallon-imperial", "jigger", "koku", "kosaji", "liter", "osaji", "pinch", "pint", "pint-imperial", "pint-metric", "quart", "quart-imperial", "sai", "shaku", "tablespoon", "teaspoon", "to-jp")),
  WaveNumber("wave-number", listOf("revolution-per-meter")),
  YearDuration("year-duration", listOf("century", "decade", "month", "month-person", "quarter", "year", "year-person")),
}
